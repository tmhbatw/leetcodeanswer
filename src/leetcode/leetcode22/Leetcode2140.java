package leetcode.leetcode22;

public class Leetcode2140 {

    //倒序dp
    //dp[j]存储的是从第j个数到最后一个数的分数的最大值
    public long mostPoints(int[][] questions) {
        int length=questions.length;
        long[] result=new long[length+1];

        for(int j=length-1;j>=0;j--){
            int bigIndex=Math.min(questions[j][1]+j+1,length);
            result[j]=Math.max(result[j+1],result[bigIndex]+questions[j][0]);
        }
        return result[0];
    }

}
