package forOffer;

public class forOffer33 {
    /*Description
    * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，
    * 否则返回 false。假设输入的数组的任意两个数字都互不相同。
    * */

    public boolean verifyPostorder(int[] postorder) {
        return verifyPostorder(postorder,0,postorder.length-1);
    }

    private boolean verifyPostorder(int[] postorder,int start,int end){
        if(end-start<=0)
            return true;
        int index=start;
        for(;index<end;index++){
            if(postorder[index]>postorder[end])
                break;
        }
        for(int i=index;i<end;i++){
            if(postorder[i]<postorder[end])
                return false;
        }
        return verifyPostorder(postorder,start,index-1)
                &&verifyPostorder(postorder,index,end-1);
    }
}
