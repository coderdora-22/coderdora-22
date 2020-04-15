package Arrays;
/*
* Given an array arr of N integers. Find the contiguous sub-array with maximum sum.

Input:
The first line of input contains an integer T denoting the number of test cases. The description of T test cases follows. The first line of each test case contains a single integer N denoting the size of array. The second line contains N space-separated integers A1, A2, ..., AN denoting the elements of the array.

Output:
Print the maximum sum of the contiguous sub-array in a separate line for each test case.

Constraints:
1 ≤ T ≤ 110
1 ≤ N ≤ 106
-107 ≤ A[i] <= 107

Example:
Input
2
5
1 2 3 -2 5
4
-1 -2 -3 -4
Output
9
-1

Explanation:
Testcase 1: Max subarray sum is 9 of elements (1, 2, 3, -2, 5) which is a contiguous subarray.
* */
//import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class KadanesAlgorithm {

    private static long getSum(List<Integer> ls){
        List<Integer> sums = new ArrayList<>();
        for(int i=0;i<ls.size()-1;i++){
            int j=i+1;
            while(j<=ls.size()) {
                int sum = ls.subList(i, j).stream().reduce((x, y) -> x + y).orElseThrow(NoSuchElementException::new);
                System.out.println(sum + " " + ls.subList(i, j));
                sums.add(sum);
                j++;
            }
        }
        System.out.println();
        long maxm = Collections.max(sums);
        if(maxm>0){
            return maxm;
        }else{
            return -1;
        }
    }
    //logical approach
    private static long getsum1(List<Integer> ls, int size){
        int curmax = ls.get(0);
        int gmax = ls.get(0);
        for(int i=1;i<ls.size();i++){
            curmax = Collections.max(Arrays.asList(ls.get(i),ls.get(i)+curmax));
            gmax = Collections.max(Arrays.asList(curmax,gmax));
        }
        System.out.println(gmax);
        return gmax;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x=Integer.parseInt(sc.nextLine());
        while(x-->0){
            sc.nextLine();
            List<Integer> ls = Arrays.stream(sc.nextLine().split(" ")).map((x1)->{return Integer.parseInt(x1);}).collect(Collectors.toList());
//            System.out.println(getSum(ls));
            System.out.println(getsum1(ls,ls.size()));
        }
    }
}
