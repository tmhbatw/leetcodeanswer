package leetcode.leetcode15;

import java.util.Arrays;

public class Leetcode1423 {

//    public int maxScore(int[] cardPoints, int k) {
//        int sum= Arrays.stream(cardPoints).sum();
//        int[] num=new int[cardPoints.length+1];
//        for(int i=0;i<cardPoints.length;i++)
//            num[i+1]=num[i]+cardPoints[i];
//
//        int min=Integer.MIN_VALUE;
//        int l=cardPoints.length-k;
//        for(int i=0;i<=cardPoints.length-l;i++){
//            min=Math.min(min,num[i+l]-num[i]);
//        }
//        return sum-min;
//    }

    public int maxScore(int[] cardPoints, int k) {
        int sum=0;

        int min=Integer.MAX_VALUE;
        int cur=0;
        int l=cardPoints.length-k;
        for(int i=0;i<cardPoints.length;i++){
            if(i>=l){
                min=Math.min(min,cur);
                cur-=cardPoints[i-l];
            }
            sum+=cardPoints[i];
            cur+=cardPoints[i];
        }
        return sum-Math.min(min,cur);
    }
}
