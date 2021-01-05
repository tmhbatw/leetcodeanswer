package leetcode2;

import java.util.*;

public class Leetcode131 {
    /*Description
    * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
    * 返回 s 所有可能的分割方案。
    * */

    public List<List<String>> partition(String s) {
        List<List<String>> result=new ArrayList<>();
        if(s==null||s.length()==0)
            return result;
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
        result=recursion(dp,new HashMap<>(),0,sLength, s);
        return result;
    }

    private List<List<String>> recursion(boolean[][] dp, Map<Integer,List<List<String>>> map,int start,int sLength,String s){
        if(start==sLength)
            return new ArrayList<>();
        if(map.containsKey(start))
            return map.get(start);
        List<List<String>> result=new ArrayList<>();
        if(start==sLength-1){
            List<String> curRes=new ArrayList<>();
            curRes.add(s.substring(start));
            result.add(curRes);
            return result;
        }
        for(int i=start;i<sLength-1;i++){
            if(dp[start][i]){
                List<List<String>> list=recursion(dp,map,i+1,sLength,s);
                for(List<String> cur:list){
                    List<String> curRes=new ArrayList<>();
                    curRes.add(s.substring(start,i+1));
                    curRes.addAll(cur);
                    result.add(curRes);
                }
            }
        }
        if(dp[start][sLength-1]){
            List<String> cur=new ArrayList<>();
            cur.add(s.substring(start));
            result.add(cur);
        }
        map.put(start,result);
        return result;
    }

    public static void main(String[] args){
        List<List<String>> list=new Leetcode131().partition("aab");
        for(List<String> cur:list)
            System.out.println(cur);
    }
}
