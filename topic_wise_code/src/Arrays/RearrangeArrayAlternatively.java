package Arrays;

public class RearrangeArrayAlternatively {
    private static int[] rearrange(int[] arr, int n){
        int i=0;
        int r=n-1;
        int l=0;
        int max_element=arr[r]+1;
        while(i<arr.length){

//            arr[i] += arr[max_index] % max_element * max_element maxelement =>arr[0]+=1+9%10*10 ==91
//            max_index--
            if (i%2==0) {
                arr[i]+=arr[r]%max_element*max_element;
                System.out.println(arr[l]+"--"+arr[r]%max_element*max_element+" --"+arr[i]);
                r--;
            }else{
                arr[i]+=arr[l]%max_element*max_element;
                System.out.println(arr[l]+"--"+arr[l]%max_element*max_element+" ----"+arr[i]);
                l++;
            }
            i++;
        }
        for (int j = 0; j < n; j++) {
            arr[j] = arr[j] / max_element;
            System.out.println(arr[j]);

        }
        for(int i1:arr){
            System.out.println(i1);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        int res[]=rearrange(arr,arr.length);
    }
}
