package leetcode6;

import java.util.Arrays;
import java.util.Comparator;

public class Leetcode506 {
    /*Description
    *给出N 名运动员的成绩，找出他们的相对名次并授予前三名对应的奖牌。
    * 前三名运动员将会被分别授予 “金牌”，“银牌” 和“ 铜牌”（"Gold Medal", "Silver Medal", "Bronze Medal"）。
    * (注：分数越高的选手，排名越靠前。)
    * */

    public String[] findRelativeRanks(int[] score) {
        int length=score.length;
        int[][] scores=new int[length][2];
        for(int i=0;i<length;i++){
            scores[i]=new int[]{score[i],i};
        }
        Arrays.sort(scores, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0]-o1[0];
            }
        });
        String[] result=new String[length];
        for(int i=0;i<length;i++){
            int index=scores[i][1];
            String curRes="";
            switch (i){
                case 0:
                    curRes="Gold Medal";
                    break;
                case 1:
                    curRes="Silver Medal";
                    break;
                case 2:
                    curRes="Bronze Medal";
                    break;
                default:
                    curRes=i+1+"";
            }
            result[index]=curRes;
        }
        return result;
    }
}
