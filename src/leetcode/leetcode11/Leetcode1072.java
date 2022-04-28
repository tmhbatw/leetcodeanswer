package leetcode.leetcode11;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Leetcode1072 {

    public int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String,Integer> set=new HashMap<>();
        for(int[] m:matrix){
            int count = 0;
            int pre = -1;

            StringBuilder sb=new StringBuilder();
            for(int num:m){
                if(num==pre){
                    count++;
                }else{
                    sb.append(count).append(" ");
                    pre = num;
                    count = 1;
                }
            }
            sb.append(count);
            set.put(sb.toString(),set.getOrDefault(sb.toString(),0)+1);
        }

        int result = 0;
        for(String key:set.keySet()){
            result=Math.max(set.get(key),result);
        }
        return result;
    }
}
