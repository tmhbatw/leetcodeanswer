package leetcode2;

import java.util.*;

public class Leetcode126 {
    /*Description
    * 给定两个单词（beginWord 和 endWord）和一个字典 wordList，
    * 找出所有从 beginWord 到 endWord 的最短转换序列。转换需遵循如下规则：
    * 每次转换只能改变一个字母。转换后得到的单词必须是字典中的单词。
    * 说明:
    * 如果不存在这样的转换序列，返回一个空列表。
    * 所有单词具有相同的长度。
    * 所有单词只由小写字母组成。
    * 字典中不存在重复的单词。
    * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
    * */

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res=new ArrayList<>();
        Map<String,Boolean> map=new HashMap<>();
        Map<String,List<String>> wordMap=new HashMap<>();
        boolean flag=false;
        for(String cur:wordList)
            map.put(cur,true);
        map.put(beginWord,false);
        Queue<String> q=new LinkedList<>();
        q.add(beginWord);
        while(!q.isEmpty()){
            int size=q.size();
            Set<String> set=new HashSet<>();
            while(size-->0){
                String cur=q.poll();
                List<String> list=getWordList(cur,map,wordMap);
                for(String curr:list){
                    if(curr.equals(endWord)) {
                        flag=true;
                    }
                    set.add(curr);
                }
            }
            for(String curr:set){
                map.put(curr,false);
                q.add(curr);
            }
            if(flag) {
                getRes(res, endWord, beginWord, wordMap,new ArrayList<>());
                return res;
            }
        }
        return res;
    }

    private void getRes(List<List<String>> result,String end,String start,Map<String,List<String>> wordMap,List<String> res){
        if(end.equals(start)){
            res.add(start);
            result.add(res);
            return;
        }
        List<String> curRes=new ArrayList<>(res);
        curRes.add(0,end);
        List<String> list=wordMap.get(end);
        for(String curr:list){
            getRes(result,curr,start,wordMap,curRes);
        }
    }

    private List<String> getWordList(String cur,Map<String,Boolean> map,Map<String,List<String>> wordMap){
        List<String> res=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<cur.length();i++){
            char curr=cur.charAt(i);
            for(int j=0;j<26;j++){
                char c=(char)(j+'a');
                String left=cur.substring(i+1);
                if(c!=curr){
                    sb.append(c);
                    String curS=sb.toString()+left;
                    if(map.getOrDefault(curS,false)) {
                        res.add(curS);
                        List<String> list=wordMap.getOrDefault(curS,new ArrayList<>());
                        list.add(cur);
                        wordMap.put(curS,list);
                    }
                    sb.deleteCharAt(i);
                }
            }
            sb.append(curr);
        }
        return res;
    }

    public static void main(String[] args){
        String beginWord = "hit",endWord = "cog";
        String[] wordList = {"hot","dot","dog","lot","log","cog"};
        List<List<String>> list= new Leetcode126().findLadders(beginWord,endWord, Arrays.asList(wordList.clone()));
        for(List<String> cur:list)
            System.out.println(cur);

    }
}
