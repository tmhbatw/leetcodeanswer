package leetcode1;

import java.util.*;

public class Leetcode30 {
    /*Description
    * 给定一个字符串s和一些长度相同的单词words。找出 s 中恰好可以由words 中所有单词串联形成的子串的起始位置。
    * 注意子串要与words 中的单词完全匹配，中间不能有其他字符，但不需要考虑words中单词串联的顺序。
    * */

    public List<Integer> findSubstring(String s, String[] words) {
        if(s==null||s.length()==0||words==null||words.length==0)
            return Collections.emptyList();
        Map<String,Integer> map=new HashMap<>();
        for(String cur:words)
            map.put(cur,map.getOrDefault(cur,0)+1);
        int wordLength=words[0].length();
        int number=words.length;
        int length=wordLength*number;
        List<Integer> result=new ArrayList<>();
        for(int i=0;i<s.length()-length+1;i++){
            if(isMatch(s,i,map,length,wordLength))
                result.add(i);
        }
        return result;
    }

    private boolean isMatch(String s, int start,Map<String,Integer> map,int length,int wordLength){
        Map<String,Integer> curMap=new HashMap<>(map);
        for(int i=start;i<start+length;i+=wordLength){
            String cur=s.substring(i,i+wordLength);
            if(!curMap.containsKey(cur)||curMap.get(cur)<1) {
                curMap.clear();
                return false;
            }
            curMap.put(cur,curMap.get(cur)-1);
        }
        curMap.clear();
        return true;
    }
}
