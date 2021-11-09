package leetcode.leetcode9;

import java.util.Arrays;

public class Leetcode820 {

    class Trie{
        Trie[] children;
        public Trie(){
            this.children=new Trie[26];
        }
    }
    Trie root;
    public int minimumLengthEncoding(String[] words) {
        this.root=new Trie();
        Arrays.sort(words,(o1,o2)->{
            return o2.length()-o1.length();
        });

        int result=0;
        for(String word:words){
            boolean exist=true;
            Trie node=root;
            for(int i=word.length()-1;i>=0;i--){
                char cur=word.charAt(i);
                if(node.children[cur-'a']==null){
                    exist=false;
                    node.children[cur-'a']=new Trie();
                }
                node=node.children[cur-'a'];
            }
            if(!exist)
                result+=word.length()+1;
        }
        return result;
    }
}
