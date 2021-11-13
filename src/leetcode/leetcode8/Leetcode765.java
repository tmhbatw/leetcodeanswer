package leetcode.leetcode8;

import java.util.HashMap;
import java.util.Map;

public class Leetcode765 {

    public int minSwapsCouples(int[] row) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<row.length;i++)
            map.put(row[i],i);

        int result=0;
        for(int i=0;i<row.length;i+=2){
            int another=getAnother(row[i]);
            if(row[i+1]==another)
                continue;
            result++;
            int index=map.get(another);
            row[index]=row[i+1];
            map.put(row[i+1],index);
        }
        return result;
    }

    private int getAnother(int cur){
        return cur/2*2+(1-cur%2);
    }
}
