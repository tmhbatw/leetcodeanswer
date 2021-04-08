package leetcode.leetcode3;

import java.util.HashMap;
import java.util.Map;

public class Leetcode208 {
    /*Description
    * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
    * */

    class Trie {
        Map<Character,Trie> map;
        /** Initialize your data structure here. */
        public Trie() {
            map=new HashMap<>();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            insert(word,0);
        }

        private void insert(String word,int index){
            Trie cur=this;
            while(index<word.length()){
                char c=word.charAt(index++);
                if(!cur.map.containsKey(c))
                    cur.map.put(c,new Trie());
                cur=cur.map.get(c);
            }
            cur.map.put(' ',new Trie());
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            Trie cur=this;
            for(int i=0;i<word.length();i++){
                char c=word.charAt(i);
                if(!cur.map.containsKey(c))
                    return false;
                cur=cur.map.get(c);
            }
            return cur.map.containsKey(' ');
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            Trie cur=this;
            for(int i=0;i<prefix.length();i++){
                char c=prefix.charAt(i);
                if(!cur.map.containsKey(c))
                    return false;
                cur=cur.map.get(c);
            }
            return true;
        }
    }

}
