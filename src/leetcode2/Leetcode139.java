package leetcode2;

import java.util.*;

public class Leetcode139 {
    /*Description
    * 给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定s 是否可以被空格拆分为一个或多个在字典中出现的单词。
    * 说明：
    * 拆分时可以重复使用字典中的单词。
    * 你可以假设字典中没有重复的单词。
    * */

    Map<Integer,Boolean> map=new HashMap<>();
    Set<String> set=new HashSet<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        set.addAll(wordDict);
        boolean result= wordBreak(s,0);
        return result;
    }

    private boolean wordBreak(String s,int start){
        if(map.containsKey(start))
            return map.get(start);
        if(start>=s.length())
            return true;
        for(int i=start+1;i<=s.length();i++){
            if(set.contains(s.substring(start,i))&&wordBreak(s,i)){
                map.put(start,true);
                return true;
            }
        }
        map.put(start,false);
        return false;
    }

    public static void main(String[] args){
        String s="leetcode";
        String[] wordDict = {"leet", "code"};
        System.out.println(new Leetcode139().wordBreak(s,Arrays.asList(wordDict)));
    }
}
