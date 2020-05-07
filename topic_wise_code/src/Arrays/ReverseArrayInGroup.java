package Arrays;
//port java.awt.*;
import java.util.*;

public class ReverseArrayInGroup {
    private static void reverseGroup(int[] arr, int offset){
        int j=0;int i=0;
        boolean lock=true;
//        int []arr2 = new int[arr.length];
        List<Integer> arr2 = new ArrayList<Integer>();
        for( i=0;i<arr.length;i+=offset){
            if(lock) {
                    j =i + offset < arr.length? (i + offset - 1): arr.length - 1;
                for (; j >=i; j--) {
//                    System.out.println(arr[j]);
                    arr2.add(arr[j]);
                }
                lock=false;
            }else{
                j=i;
                for(;j<i+offset;j++){
//                    System.out.println(arr[j]);
                    arr2.add(arr[j]);
                }
                lock=true;
            }
        }
        System.out.println(arr2);
    }


    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
       reverseGroup(arr,4);
    }
}
