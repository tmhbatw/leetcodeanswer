package leetcode.leetcode19;

public class Leetcode1804 {

    class Trie {

        Trie[] child;
        int num1;
        int num2;
        public Trie() {
            this.child=new Trie[26];
            this.num1=0;
            this.num2=0;
        }

        public void insert(String word) {
            Trie cur=this;
            for(int i=0;i<word.length();i++){
                int index=word.charAt(i)-'a';
                if(cur.child[index]==null)
                    cur.child[index]=new Trie();

                cur=cur.child[index];
                cur.num1++;
            }
            cur.num2++;
        }

        public int countWordsEqualTo(String word) {
            Trie cur=this;
            for(int i=0;i<word.length();i++){
                int index=word.charAt(i)-'a';
                if(cur.child[index]==null)
                    return 0;

                cur=cur.child[index];
            }
            return cur.num2;
        }

        public int countWordsStartingWith(String prefix) {
            Trie cur=this;
            for(int i=0;i<prefix.length();i++){
                int index=prefix.charAt(i)-'a';
                if(cur.child[index]==null)
                    return 0;

                cur=cur.child[index];
            }
            return cur.num1;
        }

        public void erase(String word) {
            Trie cur=this;
            for(int i=0;i<word.length();i++){
                int index=word.charAt(i)-'a';
                cur=cur.child[index];
                cur.num1--;
            }
            cur.num2--;
        }
    }
}
