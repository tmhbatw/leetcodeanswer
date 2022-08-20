package leetcode.leetcode11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Leetcode1007 {

    private boolean exist(int cur,int[] tops,int[] bottoms){
        for(int i=0;i<tops.length;i++){
            if(cur!=tops[i]&&cur!=bottoms[i])
                return false;
        }
        return true;
    }
    public int minDominoRotations(int[] tops, int[] bottoms) {

        int result=Integer.MAX_VALUE;
        if(exist(tops[0],tops,bottoms)){
            int cur=tops[0];
            result=Math.min(result,getRes(tops,cur));
            result=Math.min(result,getRes(bottoms,cur));
        }
        if(exist(bottoms[0],tops,bottoms)){
            int cur = bottoms[0];
            result=Math.min(result,getRes(tops,cur));
            result=Math.min(result,getRes(bottoms,cur));
        }
        return result==Integer.MAX_VALUE?-1:result;
    }

    private int getRes(int[] tops,int cur){
        int count=0;
        for(int num:tops){
            if(num!=cur)
                count++;
        }
        return count;
    }
}
