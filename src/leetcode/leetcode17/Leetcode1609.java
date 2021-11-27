package leetcode.leetcode17;

import datastructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode1609 {

    // 0 奇数，单增
    // 1 偶数，单减

    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        boolean isEven=true;

        q.add(root);

        while(!q.isEmpty()){
            int size=q.size();
            int pre=isEven?0:Integer.MAX_VALUE;
            while(size-->0){
                TreeNode cur=q.poll();
                if(cur.left!=null)
                    q.add(cur.left);
                if(cur.right!=null)
                    q.add(cur.right);
                if(isEven){
                    if(cur.val%2==0||cur.val<=pre)
                        return false;
                    pre=cur.val;
                }else{
                    if(cur.val%2==1||cur.val>=pre)
                        return false;
                    pre=cur.val;
                }
            }
            isEven=!isEven;
        }
        return true;
    }
}
