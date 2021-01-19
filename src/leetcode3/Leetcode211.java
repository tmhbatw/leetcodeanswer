package leetcode3;

import java.util.HashMap;
import java.util.Map;

public class Leetcode211 {
    /*Description
    *请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。
    * 实现词典类 WordDictionary ：
    * WordDictionary() 初始化词典对象
    * void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配
    * bool search(word) 如果数据结构中存在字符串与word 匹配，则返回 true ；否则，返回 false 。
    * word 中可能包含一些 '.' ，每个. 都可以表示任何一个字母。
    * */

    class WordDictionary {
        Map<Character, WordDictionary> map;

        /** Initialize your data structure here. */
        public WordDictionary() {
            map=new HashMap<>();
        }

        /** Adds a word into the data structure. */
        public void addWord(String word) {
            Map<Character,WordDictionary> map=this.map;
            for(int i=0;i<word.length();i++){
                char c=word.charAt(i);
                if(!map.containsKey(c))
                    map.put(c,new WordDictionary());
                map=map.get(c).map;
            }
            map.put(' ',new WordDictionary());
        }

        /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
        public boolean search(String word) {
            return search(word,0,this.map);
        }

        private boolean search(String word,int index,Map<Character,WordDictionary> map){
            if(index==word.length()){
                return map.containsKey(' ');
            }
            char c=word.charAt(index);
            if(c=='.'){
                for(Map.Entry entry:map.entrySet()){
                    WordDictionary cur= (WordDictionary) entry.getValue();
                    if(search(word,index+1,cur.map))
                        return true;
                }
                return false;
            }
            if(!map.containsKey(c))
                return false;
            return search(word,index+1,map.get(c).map);
        }
    }
}
