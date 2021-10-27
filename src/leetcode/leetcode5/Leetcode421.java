package leetcode.leetcode5;

import java.util.Arrays;

public class Leetcode421 {

    class Trie{
        Trie[] child;
        public Trie(){
            child=new Trie[2];
        }
    }

    Trie root=new Trie();
    int[] num;
    public int findMaximumXOR(int[] nums) {
        int result=0;
        init();

        for(int cur:nums){
            insert(root,cur);
            result=Math.max(getRes(root,cur),result);
        }
        return result;
    }

    private int getRes(Trie root,int n){
        int res=0;
        for(int i=0;i<num.length;i++){
            int index=1;
            if(n>=num[i]){
                index=0;
                n-=num[i];
            }
            if(root.child[1-index]!=null){
                res+=num[i];
                root=root.child[1-index];
            }else
                root=root.child[index];
        }
        return res;
    }

    private void insert(Trie root,int n){
        for(int i=0;i<num.length;i++){
            if(n>=num[i]){
                if(root.child[0]==null)
                    root.child[0]=new Trie();
                root=root.child[0];
                n-=num[i];
            }else{
                if(root.child[1]==null)
                    root.child[1]=new Trie();
                root=root.child[1];
            }
        }
    }

    private void init(){
        this.num=new int[31];
        int base=1;
        for(int j=30;j>=0;j--){
            num[j]=base;
            base*=2;
        }
    }
}
