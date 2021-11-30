package leetcode.leetcode10;

public class Leetcode926 {

    public int minFlipsMonoIncr(String s) {
        int length=s.length();
        int[] sum=new int[length+1];

        for(int i=0;i<s.length();i++){
            sum[i+1]+=sum[i]+s.charAt(i)-'0';
        }

        int result=length-sum[length];
        for(int i=0;i<length;i++){
            result=Math.min(result,sum[i+1]+(length-i-1-(sum[length]-sum[i+1])));
        }

        return result;
    }
}
