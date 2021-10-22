package forOffer2;

import java.util.Arrays;

public class ForOffer65 {

    class Trie{
        Trie[] child;
        public Trie(){
            this.child=new Trie[26];
        }
    }
    public int minimumLengthEncoding(String[] words) {
        Arrays.sort(words,(o1,o2)->{
            return o2.length()-o1.length();
        });
        Trie root=new Trie();

        int result=0;
        for(String cur:words){
            result+=getRes(root,cur);
        }

        return result;
    }

    private int getRes(Trie root,String cur){
        boolean flag=true;
        for(int j=cur.length()-1;j>=0;j--){
            int index=cur.charAt(j)-'a';
            if(root.child[index]==null){
                flag=false;
                root.child[index]=new Trie();
            }
            root=root.child[index];
        }
        return flag?0:cur.length()+1;
    }
}
