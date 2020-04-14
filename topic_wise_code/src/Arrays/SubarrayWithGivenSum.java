package Arrays;
/*
Given an unsorted array A of size N of non-negative integers, find a continuous sub-array which adds to a given number S.

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case consists of two lines. The first line of each test case is N and S, where N is the size of array and S is the sum. The second line of each test case contains N space separated integers denoting the array elements.

Output:
For each testcase, in a new line, print the starting and ending positions(1 indexing) of first such occuring subarray from the left if sum equals to subarray, else print -1.


Example:
Input:
2
5 12
1 2 3 7 5
10 15
1 2 3 4 5 6 7 8 9 10
Output:
2 4
1 5

Explanation :
Testcase1: sum of elements from 2nd position to 4th position is 12
Testcase2: sum of elements from 1st position to 5th position is 15*/

import java.lang.reflect.Array;
import java.util.*;

public class SubarrayWithGivenSum {
    private static String getSum(List<Integer> ls,long sum){
        long tempsum =0;
        int start=0,end=0;
        int i=0;
        for(i=0;i<ls.size();i++){
            tempsum=0;
            start=i+1;
            end=i;
            while(tempsum<sum && end<ls.size()){
                tempsum+=ls.get(end);
                end++;
            }
            if(tempsum==sum) {
                break;
            }
        }
        if(tempsum!=sum){
            return "-1";
        }
        return ""+start+" "+end;
    }



    public static void main(String[] args) {

        List<Integer> inputArr = new ArrayList();
        inputArr.addAll(Arrays.asList(1,2,3,7,5));
        int sum1 = 12;
        System.out.println(getSum(inputArr,sum1));

        List<Integer> inputArr2 =new ArrayList<>();
        inputArr2.addAll(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
        int sum2 = 15;
        System.out.println(getSum(inputArr2,sum2));
    }
}
