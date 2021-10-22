package forOffer2;

import java.util.List;

public class ForOffer63 {

    class Trie{
        Trie[] child;
        boolean exist;
        public Trie(){
            this.child=new Trie[26];
            this.exist=false;
        }
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie root=new Trie();
        for(String cur:dictionary)
            insert(root,cur);
        String[] ss=sentence.split(" ");
        StringBuilder sb=new StringBuilder();
        for(String cur:ss){
            sb.append(" ").append(getRes(root,cur));
        }
        return sb.substring(1);
    }

    private void insert(Trie root,String word){
        for(int i=0;i<word.length();i++){
            int index=word.charAt(i)-'a';
            if(root.child[index]==null)
                root.child[index]=new Trie();
            root=root.child[index];
        }
        root.exist=true;
    }

    private String getRes(Trie root,String word){
        for(int i=0;i<word.length();i++){
            int index=word.charAt(i)-'a';
            if(root.child[index]==null)
                return word;
            root=root.child[index];
            if(root.exist)
                return word.substring(0,i+1);
        }
        return word;
    }
}
