package interview;

import java.util.*;

public class Problem17_25 {

    class Trie{
        Trie[] child;
        boolean isLeaf;
        public Trie(){
            this.child=new Trie[26];
            this.isLeaf=false;
        }
    }

    Trie root=new Trie();
    int maxLength=0;
    int maxArea=0;
    List<String> result=new ArrayList<>();
    Map<Integer, Set<String>> map=new HashMap<>();
    public String[] maxRectangle(String[] words) {
        for(String word:words){
            insert(word);
            map.putIfAbsent(word.length(),new HashSet<>());
            map.get(word.length()).add(word);
            maxLength=Math.max(maxLength,word.length());
        }

        for(int row:map.keySet())
            dfs(row,0,map.get(row),new ArrayList<>());

        return result.toArray(new String[]{});
    }

    private void dfs(int row,int col,Set<String> set,List<String> list){
        if(row*maxLength<maxArea||col==maxLength)
            return;

        for(String next:set){
            list.add(next);
            int curRes=getExist(list);
            if(curRes==2){
                if((col+1)*row>maxArea){
                    maxArea=(col+1)*row;
                    result=new ArrayList<>(list);
                }
                dfs(row,col+1,set,list);
            }
            if(curRes==1){
                dfs(row,col+1,set,list);
            }
            list.remove(list.size()-1);
        }
    }

    //为0表示不能进行，为1表示还可能继续迭代，为2表示没毛病
    private int getExist(List<String> list){
        boolean status2=true;
        for(int j=0;j<list.get(0).length();j++){
            Trie cur=root;
            for(int i=0;i<list.size();i++){
                int index=list.get(i).charAt(j)-'a';
                if(cur.child[index]==null)
                    return 0;
                cur=cur.child[index];
            }
            if(!cur.isLeaf){
                status2=false;
            }
        }
        return status2?2:1;
    }

    private void insert(String word){
        Trie cur=root;
        for(int i=0;i<word.length();i++){
            int index=word.charAt(i)-'a';
            if(cur.child[index]==null)
                cur.child[index]=new Trie();
            cur=cur.child[index];
        }
        cur.isLeaf=true;
    }
}
