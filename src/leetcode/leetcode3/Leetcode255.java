package leetcode.leetcode3;

public class Leetcode255 {
    /*Description
    *给定一个整数数组，你需要验证它是否是一个二叉搜索树正确的先序遍历序列。
    * 你可以假定该序列中的数都是不相同的。
    * 参考以下这颗二叉搜索树：
    * */

    public boolean verifyPreorder(int[] preorder) {
        if(preorder==null)
            return true;
        return verifyPreorder(preorder,0,preorder.length-1);
    }

    private boolean verifyPreorder(int[] preorder,int start,int end){
        if(start>=end)
            return true;
        int bigIndex=end+1;
        int val=preorder[start];
        for(int i=start+1;i<=end;i++){
            if(preorder[i]>val){
                bigIndex=i;
                break;
            }
        }
        for(int i=bigIndex+1;i<=end;i++){
            if(preorder[i]<val)
                return false;
        }
        return verifyPreorder(preorder,start+1,bigIndex-1)&&
                verifyPreorder(preorder,bigIndex,end);
    }
}
