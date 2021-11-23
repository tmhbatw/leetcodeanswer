package leetcode.leetcode7;

import java.time.Year;
import java.util.List;

public class Leetcode648 {

    class Trie{
        Trie[] child;
        boolean exist=false;
        public Trie(){
            this.child=new Trie[26];
        }
    }

    Trie root=new Trie();

    public String replaceWords(List<String> dictionary, String sentence) {
        for(String dic:dictionary){
            insert(dic);
        }
        StringBuilder sb=new StringBuilder();
        for(String s:sentence.split(" ")){
            sb.append(" ").append(getRes(s));
        }
        return sb.substring(1);
    }

    private String getRes(String s){
        Trie cur=root;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(cur.child[c-'a']==null)
                return s;
            cur=cur.child[c-'a'];
            if(cur.exist)
                return s.substring(0,i+1);
        }
        return s;
    }

    private void insert(String cur){
        Trie trie=root;
        for(int i=0;i<cur.length();i++){
            char c=cur.charAt(i);
            if(trie.child[c-'a']==null)
                trie.child[c-'a']=new Trie();
            trie=trie.child[c-'a'];
        }
        trie.exist=true;
    }
}
