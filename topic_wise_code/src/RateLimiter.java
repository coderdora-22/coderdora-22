import java.util.Random;

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
