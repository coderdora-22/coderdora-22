package Arrays;
import java.math.*;
public class NumberOfPairs {
    //OPTIMIZED SOLUTION



    //BRUTE FORCE METHOD
    public static int pairs(int[] arr1, int[] arr2){
        int count=0;
        for(int i=0;i<arr1.length;i++){
            int x=arr1[i];
            for(int j=0;j<arr2.length;j++){
                int y=arr2[j];
                if(Math.pow(x,y)>Math.pow(y,x)){
                    count+=1;
                }
            }
        }
        return count;
    }

    public static void main(String[] args){

    }

}
