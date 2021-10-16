package leetcode.leetcode17;

import java.util.Arrays;

public class Leetcode1619 {

    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        int sum= Arrays.stream(arr).sum();
        int fiveNumber=arr.length/20;
        for(int i=0;i<fiveNumber;i++)
            sum-=arr[i];
        for(int i=arr.length-fiveNumber;i<arr.length;i++){
            sum-=arr[i];
        }
        return sum*1.0/(arr.length-fiveNumber*2);
    }
}
