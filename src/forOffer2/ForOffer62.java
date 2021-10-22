package forOffer2;

public class ForOffer62 {

    class Trie {

        Trie[] child;
        boolean exist;
        /** Initialize your data structure here. */
        public Trie() {
            this.child=new Trie[26];
            this.exist=false;
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            Trie cur=this;
            for(int i=0;i<word.length();i++){
                char c=word.charAt(i);
                if(cur.child[c-'a']==null)
                    cur.child[c-'a']=new Trie();
                cur=cur.child[c-'a'];
            }
            cur.exist=true;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            Trie cur=this;
            for(int i=0;i<word.length();i++){
                char c=word.charAt(i);
                if(cur.child[c-'a']==null)
                    return false;
                cur=cur.child[c-'a'];
            }
            return cur.exist;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            Trie cur=this;
            for(int i=0;i<prefix.length();i++){
                char c=prefix.charAt(i);
                if(cur.child[c-'a']==null)
                    return false;
                cur=cur.child[c-'a'];
            }
            return true;
        }
    }
}
