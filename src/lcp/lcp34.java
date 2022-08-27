package lcp;

import datastructure.TreeNode;

public class lcp34 {

    int k;
    public int maxValue(TreeNode root, int k) {
        this.k=k;
        int[] result=getRes(root);
        return max(result);
    }

    private int[] getRes(TreeNode root){
        int[] res=new int[k+1];

        if(root==null)
            return res;

        int[] l=getRes(root.left);
        int[] r=getRes(root.right);
        for(int i=0;i<r.length;i++){
            for(int j=0;j<l.length;j++){
                if(i+j>k)
                    break;
                res[i+j]=Math.max(res[i+j],l[i]+r[j]);
            }
        }

        for(int j=k;j>=1;j--){
            res[j]=res[j-1]+root.val;
        }
        res[0]=max(l)+max(r);
        return res;
    }



    private int max(int[] num){
        int result=0;
        for(int n:num)
            result=Math.max(n,result);
        return result;
    }
}
