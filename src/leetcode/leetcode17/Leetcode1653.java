package leetcode.leetcode17;

public class Leetcode1653 {

    public int minimumDeletions(String s) {
        int length=s.length();
        int[] sum=new int[length+1];

        for(int i=0;i<length;i++){
            sum[i+1]=sum[i]+(s.charAt(i)=='a'?1:0);
        }

        int result=Integer.MAX_VALUE;
        for(int i=0;i<=length;i++){
            result=Math.min(result,getANumber(sum,i)+getBNumber(sum,i));
        }

        return result;
    }

    private int getBNumber(int[] sum, int i){
        return i-sum[i];
    }

    private int getANumber(int[] sum,int i){
        return sum[sum.length-1]-sum[i];
    }

}
