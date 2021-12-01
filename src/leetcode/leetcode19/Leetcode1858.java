package leetcode.leetcode19;

import datastructure.TreeNode;

import java.util.Arrays;

public class Leetcode1858 {

    class Trie{
        Trie[] child;
        public Trie(){
            this.child=new Trie[26];
        }
    }
    Trie root;

    public String longestWord(String[] words) {
        Arrays.sort(words,(o1,o2)->{
            return o1.length()-o2.length();
        });
        System.out.println(Arrays.toString(words));

        String res="";
        this.root=new Trie();
        for(String word:words){
            if(insert(word)){
                if(word.length()>res.length()||word.length()==res.length()&&word.compareTo(res)<0)
                    res=word;
            }
        }
        return res;
    }

    private boolean insert(String word){
        Trie cur=root;
        for(int i=0;i<word.length()-1;i++){
            int index=word.charAt(i)-'a';
            if(cur.child[index]==null)
                return false;
            cur=cur.child[index];
        }
        int last=word.charAt(word.length()-1)-'a';
        if(cur.child[last]==null){
            cur.child[last]=new Trie();
        }
        return true;
    }
}
