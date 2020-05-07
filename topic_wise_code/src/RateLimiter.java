import java.util.Random;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;


public class RateLimiter {
    private final long bucketcapacity;
    private final double refillTokenpermili;
    private double availableToken;
    private long lastRefillTimeStamp;

    public RateLimiter(long bucketcapacity,long refilltokens,long refillPeriodmilis) {
        this.bucketcapacity = bucketcapacity;
        refillTokenpermili =  (double)refilltokens /(double)refillPeriodmilis;
        this.availableToken = bucketcapacity;
        this.lastRefillTimeStamp = System.currentTimeMillis();
    }
    synchronized public boolean tryRequest(int num){
        refill();
        if(availableToken < num){
            return false;
        }else{
            availableToken-=num;
            return true;
        }
    }

    private void refill(){
        long currentTimeMillis = System.currentTimeMillis();
        if(currentTimeMillis < lastRefillTimeStamp){
            long millisSinceLastRefill = currentTimeMillis -lastRefillTimeStamp;
            double refillValue = millisSinceLastRefill * refillTokenpermili;
            this.availableToken = Math.min(bucketcapacity,refillValue+availableToken);
            this.lastRefillTimeStamp = currentTimeMillis;
        }
    }
    private static final class Test{
        public static void main(String[] args) {
            RateLimiter limiter = new RateLimiter(100,100,1000);
            long startMillis = System.currentTimeMillis();
            long consumed =0;
            while(System.currentTimeMillis() - startMillis < 10){
                Random random = new Random();
                if(limiter.tryRequest(2))
                    consumed++;
            }
            System.out.println(consumed);
        }
    }
}


class RateLimit {
    public int REQUEST_LIMIT = 100;
    public Long TIME_LIMIT = 1000L;
    public class HitCounter {
        public Queue<Long> queue;
        private final long requestCapacity=100;
        private final double refillCreditPerOnemilli = (double)TIME_LIMIT / 500; // because the credit limit was 500 this can vary
        private double availableCredit;
        private long lastRefillStamp;

        public HitCounter() {
            queue = new LinkedList<>();
            lastRefillStamp = System.currentTimeMillis();
            availableCredit = requestCapacity;
        }

        synchronized public boolean tryRequest(int num){
            refill();
            if(availableCredit < num){
                return false;
            }else{
                availableCredit-=num;
                return true;
            }
        }

        public void refill(){
            long currentMilliTimeStamp = System.currentTimeMillis();
            if(currentMilliTimeStamp < lastRefillStamp){
                long millisSinceLastRefill = currentMilliTimeStamp - lastRefillStamp;
                double refillValue = millisSinceLastRefill * refillCreditPerOnemilli;
                this.availableCredit = Math.min(requestCapacity,refillValue+availableCredit);
                this.lastRefillStamp = currentMilliTimeStamp;
            }
        }

        public boolean hit(long timestamp) {
            /* when a timestamp hit, we should poll all the timestamp before TIME_LIMIT*/
            while (!queue.isEmpty() && queue.peek() - timestamp >= TIME_LIMIT) {
                refill();
                if(availableCredit<timestamp)
                    return false;
                else {
                    availableCredit=availableCredit-queue.poll();
                }
            }
            if (queue.size() < 100) {
                queue.add(timestamp); return true;
            }
            return false;
        }
    }
    public HashMap<String, HitCounter> clientTimeStampMap = new HashMap<>();
    public boolean isAllow(String clientId) {
        long currTime = System.currentTimeMillis();
        if (!clientTimeStampMap.containsKey(clientId)) {
            HitCounter h = new HitCounter();
            h.hit(currTime); return true;
        } else {
            HitCounter h = clientTimeStampMap.get(clientId);
            return h.hit(currTime);
        }
    }

}
