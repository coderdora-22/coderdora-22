package Arrays;

public class MergeSortedArray {
    //works well in output but needs optimization
    private static int[] mergeArray(int[] x, int[] y){
        int minlen =x.length<y.length ? x.length:y.length;
        int i=0;
        int j=0;
//        if (minlen == 0){
//            return new int[]{-1};
//        }
//        int maxlen =x.length>=y.length ? x.length:y.length;
        int[] result = new int[x.length+y.length];
        int k=0;
        int random=-1;
        while(k<result.length){
            System.out.println(x[i]+" "+y[j]);
            if(x[i]<y[j]){
                result[k]=x[i];
                i++;
            }else if(x[i]>y[j]){
                result[k]=y[j];
                j++;
            }else{
                result[k]=x[i];
                k++;
                result[k]=y[j];
                i++;
                j++;
            }
            k++;
            if(i==x.length || j==y.length){
                random = i==x.length ? 2 : 4;
                break;
            }
        }
        if(random==2){
            for(;j<y.length;j++){
                result[k]=y[j];
                k++;
            }
        }else if(random==4){
            for(;i<x.length;i++){
                result[k]=x[i];
                k++;
            }
        }


        for(int i1:result){
            System.out.print( " "+ i1);
        }
        return result;


    }

    public static void main(String[] args) {
        int[] arr = {6,9,80};
        int[] arr1 = {6,9,9};
        int res[]=mergeArray(arr,arr1);
    }
}
