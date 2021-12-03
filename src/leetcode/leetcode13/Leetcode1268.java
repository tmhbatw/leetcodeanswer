package leetcode.leetcode13;

import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode1268 {

    class Trie{
        Trie[] child;
        List<String> res;
        public Trie(){
            this.child=new Trie[26];
            this.res=new ArrayList<>();
        }
    }
    Trie root=new Trie();
    public List<List<String>> suggestedProducts(String[] products,
                                                String searchWord) {
        Arrays.sort(products);
        for(String p:products){
            insert(p);
        }

        List<List<String>> result=new ArrayList<>();
        for(int i=0;i<searchWord.length();i++){
            if(root==null){
                result.add(new ArrayList<>());
                continue;
            }
            root=root.child[searchWord.charAt(i)-'a'];
            List<String> list=new ArrayList<>();
            if(root!=null)
                for (int j = 0; j<Math.min(root.res.size(),3);j++)
                    list.add(root.res.get(j));

            result.add(list);
        }

        return result;
    }

    private void insert(String s){
        Trie cur=root;
        for(int i=0;i<s.length();i++){
            int index=s.charAt(i)-'a';
            if(cur.child[index]==null)
                cur.child[index]=new Trie();
            cur=cur.child[index];
            cur.res.add(s);
        }
    }
}
