package Arrays;

public class InversionOfArray {
    private static int inversion(int arr[]){
        int count=0;
        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                if(i<j) {
                    if (arr[i] > arr[j]) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {2,4,1,3,5};
        System.out.println(inversion(arr));
    }
}
