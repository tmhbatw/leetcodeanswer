package leetcode.leetcode21;

import java.util.TreeSet;

public class Leetcode2055 {

    public int[] platesBetweenCandles(String s, int[][] queries) {
        TreeSet<Integer> set=new TreeSet<>();
        int[] sum=new int[s.length()+1];
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='*'){
                sum[i+1]=sum[i]+1;
            }else{
                sum[i+1]=sum[i];
                set.add(i);
            }
        }

        int[] result=new int[queries.length];
        int index=0;
        for(int[] q:queries){
            Integer big=set.floor(q[1]);
            Integer small=set.ceiling(q[0]);
            if(big==null||small==null||big<small) {
                index++;
                continue;
            }
            result[index++]=sum[big]-sum[small];
        }
        return result;
    }
}
