package forOffer2;

import java.util.HashMap;
import java.util.Map;

public class ForOffer66 {

    class MapSum {

        class Trie{
            Trie[] child;
            int sum;
            public Trie(){
                this.child=new Trie[26];
                this.sum=0;
            }
        }
        Trie root;
        Map<String,Integer> map;
        /** Initialize your data structure here. */
        public MapSum() {
            this.root=new Trie();
            this.map=new HashMap<>();
        }

        public void insert(String key, int val) {
            int del=0;
            if(map.containsKey(key)){
                del=map.get(key);
            }
            map.put(key,val);
            Trie cur=root;
            for(int i=0;i<key.length();i++){
                int c=key.charAt(i)-'a';
                if(cur.child[c]==null){
                    cur.child[c]=new Trie();
                }
                cur=cur.child[c];
                cur.sum+=val-del;
            }
        }

        public int sum(String prefix) {
            Trie cur=root;
            for(int i=0;i<prefix.length();i++){
                int c=prefix.charAt(i)-'a';
                if(cur.child[c]==null)
                    return 0;
                cur=cur.child[c];
            }
            return cur.sum;
        }
    }
}
