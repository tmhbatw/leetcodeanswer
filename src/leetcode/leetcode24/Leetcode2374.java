package leetcode.leetcode24;

public class Leetcode2374 {

    public int edgeScore(int[] edges) {
        long[] score=new long[edges.length];
        for(int i=0;i<edges.length;i++)
            score[edges[i]]+=i;

        int result=0;
        long max=0;
        for(int i=0;i<score.length;i++){
            if(score[i]>max){
                result=i;
                max=score[i];
            }
        }

        return result;
    }
}
