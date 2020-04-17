package Arrays;

public class MissingNumberInArray {
    private static int missingTerms1(int[] arr, int n){
        int sum=0;
        if(n==2){
           if(arr[0]==1){
               return 2;
           } if(arr[0]==2){
               return 1;
            }
        }
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
        }
        int ac= n*(n+1)/2;
        return ac-sum;
    }

    private static int missingTerms(int[] arr, int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(arr[i]!=arr[j] && arr[i]<arr[j]){
                    int temp=arr[j];
                    arr[j]=arr[i];
                    arr[i]=temp;
                }
            }
        }
//        for(int i:arr)
//            System.out.println(i);
//

        int l=0;
        int r=n-1;
        int miss=-1;

        if(arr[l]==1 && n==1){
            return 2;
        }
        if(arr[l]!=1 ){
            return 1;
        }else if(arr[r]!=n+1){
            return n;
        }
        while(l<r){
            System.out.println("hello"+arr[l]+arr[r]);
            if(arr[l]+1 != arr[++l]){
                miss=arr[l]-1;
                break;
            }
            if(arr[r]-1 != arr[--r]){
                miss=arr[r]+1;
                break;
            }
            System.out.println("hellodfgnh"+arr[l]+arr[r]);

        }
//        System.out.println(miss);
        return miss;
    }

    public static void main(String[] args) {

        int[] arr = {2,3,4,1,6,7};
        System.out.println(missingTerms1(arr,arr.length +1));
    }
}
