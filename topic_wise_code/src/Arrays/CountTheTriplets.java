package Arrays;
/*
* Given an array of distinct integers. The task is to count all the triplets such that sum of two elements equals the third element.

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case consists of two lines. First line of each test case contains an Integer N denoting size of array and the second line contains N space separated elements.

Output:
For each test case, print the count of all triplets, in new line. If no such triplets can form, print "-1".

Constraints:
1 <= T <= 100
3 <= N <= 105
1 <= A[i] <= 106

Example:
Input:
2
4
1 5 3 2
3
3 2 7
Output:
2
-1

Explanation:
Testcase 1: There are 2 triplets: 1 + 2 = 3 and 3 +2 = 5*/
public class CountTheTriplets {
    //fastest search in an unsorted Array
    private static boolean search(int[] arr, int n,int x){
        if(arr[n-1]==x){
            return true;
        }
        int backup =arr[n-1];
        arr[n-1]=x;
        for(int i=0;;i++){
            if(arr[i]==x){
                arr[n-1] = backup;
                if(i < n-1)
                    return true;
                return false;
            }
        }

    }

    private static int getCount(int[] ls){
        int sum=0,count=0;

        for(int i=0;i<ls.length;i++){
            for(int j=i;j<ls.length;j++){
                if(i!=j){
                  sum=ls[i]+ls[j];
//                  System.out.println(sum+" "+ls[i]+" "+ls[j]);
                  if(search(ls,ls.length,sum)) {
                      count++;
                      System.out.println(sum + " " + ls[i] + " " + ls[j]);
                  }
                }
            }
        }
        if(count==0)
            return -1;
        return count;
    }

//try countFaster => this method is slow


    public static void main(String[] args) {
        int[] arr1={1 ,5 ,3 ,2};
        System.out.println(getCount(arr1));
//        System.out.println(getCountFaster(arr1));
        int[] arr2={3,2,7};
        System.out.println(getCount(arr2));
    }
}
