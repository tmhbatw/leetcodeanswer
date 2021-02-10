package leetcode3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Leetcode269 {
    /*Description
    *现有一种使用字母的全新语言，这门语言的字母顺序与英语顺序不同。
    * 假设，您并不知道其中字母之间的先后顺序。但是，会收到词典中获得一个不为空的
    * 单词列表。因为是从词典中获得的，所以该单词列表内的单词已经按这门新语言的字母顺序进行了排序。
    * 您需要根据这个输入的列表，还原出此语言中已知的字母顺序。
    * */

    boolean[] reached=new boolean[26];
    Map<Character,Set<Character>> map=new HashMap<>();
    public String alienOrder(String[] words) {
        Set<Character> set=new HashSet<>();//用来存储所有出现过的字符
        int wordLength=words.length;
        for(int i=0;i<wordLength;i++){
            if(i!=wordLength-1){
                char[] order=getOrder(words[i],words[i+1]);
                if(order!=null){
                    if(order[0]=='F')
                        return "";
                    Set<Character> curSet=map.getOrDefault(order[1],new HashSet<>());
                    curSet.add(order[0]);
                    map.put(order[1],curSet);
                }

            }
            for(int j=0;j<words[i].length();j++){
                set.add(words[i].charAt(j));
            }
        }
        String result=getString(set);
        return result;
    }

    private String getString(Set<Character> set){
        StringBuilder sb=new StringBuilder();
        boolean[] waited=new boolean[26];
        for(char cur:set){
            if(!getRes(cur,waited,sb))
                return "";
        }
        return sb.toString();
    }

    private boolean getRes(char cur,boolean[] waited,StringBuilder sb){
        if(reached[cur-'a']){
            return true;
        }
        if(waited[cur-'a'])
            return false;
        waited[cur-'a']=true;
        Set<Character> set=map.getOrDefault(cur,new HashSet<>());
        for(char curr:set){
            if(!getRes(curr,waited,sb))
                return false;
        }
        reached[cur-'a']=true;
        waited[cur-'a']=false;
        sb.append(cur);
        return true;
    }

    private char[] getOrder(String s1,String s2){
        for(int i=0;i<Math.min(s1.length(),s2.length());i++){
            char c1=s1.charAt(i),c2=s2.charAt(i);
            if(c1!=c2)
                return new char[]{c1,c2};
        }
        if(s1.length()>s2.length())
            return new char[]{'F','F'};
        return null;
    }
}
