package leetcode.leetcode24;

import java.sql.Array;
import java.util.Arrays;

public class Leetcode2347 {

    public String bestHand(int[] ranks, char[] suits) {
        char f=suits[0];
        boolean flag=true;
        for(char cur:suits){
            if(cur!=f){
                flag=false;
                break;
            }
        }
        if(flag)
            return "Flush";

        Arrays.sort(ranks);
        int count=1;
        for(int i=0;i<5;i++){
            int cur=ranks[i];
            int start=i;
            while(i<4&&ranks[i+1]==cur)
                i++;
            count=Math.max(count,i-start+1);
        }

        switch (count){
            case 1:
                return "High Card";
            case 2:
                return "Pair";
            default:
                return "Three of a Kind";
        }
    }
}
