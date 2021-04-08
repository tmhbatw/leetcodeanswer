package leetcode.leetcode2;

import java.util.*;

public class Leetcode140 {
    /*Description
    * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，
    * 使得句子中所有的单词都在词典中。返回所有这些可能的句子。
    * 说明：
    * 分隔时可以重复使用字典中的单词。
    * 你可以假设字典中没有重复的单词。
    * */

    Map<Integer,List<String>> map=new HashMap<>();
    Set<String> set=new HashSet<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        set.addAll(wordDict);
        return wordBreak(s,0);
    }

    private List<String> wordBreak(String s,int start){
        if(map.containsKey(start))
            return map.get(start);
        if(start>=s.length())
            return new ArrayList<>();
        List<String> res=new ArrayList<>();
        for(int i=start+1;i<s.length();i++){
            if(set.contains(s.substring(start,i))){
                String cur=s.substring(start,i);
                List<String> list=wordBreak(s,i);
                for(String curr:list)
                    res.add(cur+" "+curr);
            }
        }
        if(set.contains(s.substring(start)))
            res.add(s.substring(start));
        map.put(start,res);
        return res;
    }
}
