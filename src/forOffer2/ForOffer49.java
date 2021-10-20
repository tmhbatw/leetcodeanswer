package forOffer2;

import datastructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class ForOffer49 {

    public int sumNumbers(TreeNode root) {
        if(root==null)
            return 0;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        int result=0;
        while(!q.isEmpty()){
            TreeNode cur=q.poll();
            if(cur.left==null&&cur.right==null)
                result+=cur.val;
            if(cur.left!=null){
                cur.left.val+=cur.val*10;
                q.add(cur.left);
            }
            if(cur.right!=null){
                cur.right.val+=cur.val*10;
                q.add(cur.right);
            }
        }
        return result;
    }
}
