package leetcode2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Leetcode132 {
    /*Description
    * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
    * 返回符合要求的最少分割次数。
    * */

    public int minCut(String s) {
        if(s==null||s.length()==0)
            return 0;
        int sLength=s.length();
        boolean[][] dp=new boolean[sLength][sLength];
        for(int i=0;i<sLength;i++)
            dp[i][i]=true;
        for(int i=0;i<sLength-1;i++){
            if(s.charAt(i)==s.charAt(i+1))
                dp[i][i+1]=true;
        }
        for(int length=2;length<sLength;length++){
            for(int i=0;i<sLength-length;i++){
                if(s.charAt(i)==s.charAt(i+length)&&dp[i+1][i+length-1])
                    dp[i][i+length]=true;
            }
        }
        return recursion(dp,0,sLength,new HashMap<>());
    }

    private int recursion(boolean[][] dp,int start,int sLength,HashMap<Integer,Integer> map){
        if(dp[start][sLength-1])
            return 0;
        if(map.containsKey(start))
            return map.get(start);
        int result=Integer.MAX_VALUE;
        for(int i=start;i<sLength-1;i++){
            if(dp[start][i]){
                result=Math.min(result,1+recursion(dp,i+1,sLength,map));
            }
        }
        map.put(start,result);
        return result;
    }

}
