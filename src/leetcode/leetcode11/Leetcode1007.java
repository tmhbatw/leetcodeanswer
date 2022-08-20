package leetcode.leetcode11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Leetcode1007 {

    public int minDominoRotations(int[] tops, int[] bottoms) {
        List<Integer> s=new ArrayList<>();
        s.add(tops[0]);
        s.add(bottoms[0]);

        for(int i=0;i<tops.length;i++){
            for(int index=s.size()-1;index>=0;index--){
                int cur=s.get(index);
                if(cur!=tops[i]&&cur!=bottoms[i])
                    s.remove(index);
            }

            if(s.size()==0)
                return -1;
        }

        int result=Integer.MAX_VALUE;
        for(int cur:s){
            result=Math.min(result,getRes(tops,cur));
            result=Math.min(result,getRes(bottoms,cur));
        }
        return result;
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
