package Arrays;
import java.util.*;
public class MinimumMeetingRoom {
    public static int minMeetingRooms(double[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing((double[] itv) -> itv[0]));

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int count = 0;
        for (double[] itv : intervals) {
            if (heap.isEmpty()) {
                count++;
                heap.offer((int)itv[1]);
            } else {
                System.out.println(heap.peek());
                if (itv[0] >= heap.peek()) {
                    heap.poll();
                } else {
                    count++;
                }

                heap.offer((int)itv[1]);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(minMeetingRooms(new double[][]{{10,11},{11,12},{11,13},{11.30,12}}));
    }
}
