package leetcode.leetcode13;

import java.util.*;

public class Leetcode1233 {

    class Trie{
        Map<String,Trie> map;
        boolean reached=false;

        public Trie(){
            this.map=new HashMap<>();
        }

    }

    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);

        List<String> result=new ArrayList<>();
        Trie root=new Trie();
        for(String cur:folder){
            if(!match(root,cur.split("/"),1)){
                insert(root,cur.split("/"),1);
                result.add(cur);
            }
        }

        return result;
    }

    public void insert(Trie root,String[] s,int index){
        if(index==s.length){
            root.reached=true;
            return;
        }

        root.map.putIfAbsent(s[index],new Trie());
        root=root.map.get(s[index]);
        insert(root,s,index+1);
    }

    public boolean match(Trie root,String[] s,int index){
        if(index==s.length)
            return false;

        if(root.map.containsKey(s[index])){
            root=root.map.get(s[index]);
            if(root.reached)
                return true;
            return match(root,s,index+1);
        }

        return false;
    }

    public static void main(String[] args){
        String t="/a";
        System.out.println(t);
        System.out.println(Arrays.toString(t.split("/")));
        System.out.println("hello world");
    }
}
