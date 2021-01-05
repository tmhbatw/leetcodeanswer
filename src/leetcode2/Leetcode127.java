package leetcode2;

import java.util.*;

public class Leetcode127 {
    /*Description
    * 给定两个单词（beginWord和 endWord）和一个字典，找到从beginWord 到endWord 的最短转换序列的长度。转换需遵循如下规则：
    * 每次转换只能改变一个字母。
    * 转换过程中的中间单词必须是字典中的单词。
    * 说明:
    * 如果不存在这样的转换序列，返回 0。
    * 所有单词具有相同的长度。
    * 所有单词只由小写字母组成。
    * 字典中不存在重复的单词。
    * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
    * */

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int result=0;
        Map<String,Boolean> map=new HashMap<>();
        for(String cur:wordList)
            map.put(cur,true);
        map.put(beginWord,false);
        Queue<String> q=new LinkedList<>();
        q.add(beginWord);
        while(!q.isEmpty()){
            result++;
            int size=q.size();
            while(size-->0){
                String cur=q.poll();
                List<String> list=getWordList(cur,map);
                for(String curr:list){
                    if(curr.equals(endWord))
                        return result;
                    q.add(curr);
                }
            }
        }
        return 0;
    }

    private List<String> getWordList(String cur,Map<String,Boolean> map){
        List<String> res=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<cur.length();i++){
            char curr=cur.charAt(i);
            for(int j=0;j<26;j++){
                char c=(char)(j+'a');
                String left=cur.substring(i+1);
                if(c!=curr){
                    sb.append(c);
                    if(map.getOrDefault(sb.toString()+left,false)) {
                        res.add(sb.toString() + left);
                        map.put(sb.toString()+left,false);
                    }
                    sb.deleteCharAt(i);
                }
            }
            sb.append(curr);
        }
        return res;
    }

    public static void main(String[] args){
        Map<String,Boolean> map=new HashMap<>();
        map.put("a",true);
    }
}
