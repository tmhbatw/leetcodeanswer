package leetcode.leetcode16;

public class Leetcode1588 {

    public int sumOddLengthSubarrays(int[] arr) {
        int result=0;
        int[] sum=new int[arr.length+1];
        for(int i=0;i<arr.length;i++)
            sum[i+1]=sum[i]+arr[i];
        for(int i=1;i<=arr.length;i+=2){
            for(int j=0;j<=arr.length-i;j++){
                result+=sum[i+j]-sum[j];
            }
        }
        return result;
    }
}
