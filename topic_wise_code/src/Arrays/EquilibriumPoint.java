package Arrays;

public class EquilibriumPoint {
    private static int findpt(int[] arr) {
        if (arr.length == 1)
            return arr[0];

        long totalSum = 0;
        for (int i = 0; i < arr.length; i++) {
            totalSum += arr[i];
        }
        long leftsum = arr[0];
        long rightsum = totalSum - arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (leftsum == rightsum - arr[i]) {
                return i + 1;
            } else {
                leftsum += arr[i];
                rightsum -= arr[i];
            }
        }
        return -1;
        }


    public static void main(String[] args) {
        int[] arr = {2,2};
        System.out.println(findpt(arr));
    }
}
