package leetcode.leetcode14;

import datastructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode1302 {

    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        int result=0;

        while(!q.isEmpty()){
            result=0;
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode cur=q.poll();
                result+=cur.val;
                if(cur.left!=null)
                    q.add(cur.left);
                if(cur.right!=null)
                    q.add(cur.right);
            }
        }
        return result;
    }
}
