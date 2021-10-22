package forOffer2;

import java.util.Arrays;

public class ForOffer67 {

    class Trie{
        Trie[] child;
        public Trie(){
            this.child=new Trie[2];
        }
    }

    public int findMaximumXOR(int[] nums) {
        int result=0;
        Trie root=new Trie();
        for(int cur:nums){
            insert(root,cur);
            result=Math.max(getRes(root,cur),result);
        }
        return result;
    }

    private int getRes(Trie root,int num){
        int base= (int) Math.pow(2,30);
        int result=0;
        int[] n=getChar(num);
        for(int j=30;j>=0;j--){
            int index=n[j];
            if(root.child[1-index]!=null){
                result+=base;
                root=root.child[1-index];
            }else
                root=root.child[index];
            base/=2;
        }
        return result;
    }

    private void insert(Trie root,int num){
        int[] n=getChar(num);
        for(int i=30;i>=0;i--){
            if(root.child[n[i]]==null)
                root.child[n[i]]=new Trie();
            root=root.child[n[i]];
        }
    }

    private int[] getChar(int num){
        int[] res=new int[31];
        int index=0;
        while(num>0){
            res[index++]=num%2;
            num/=2;
        }
        return res;
    }

    public static void main(String[] args){
        int test=10;
        System.out.println(Arrays.toString(new ForOffer67().getChar(test)));
    }
}
