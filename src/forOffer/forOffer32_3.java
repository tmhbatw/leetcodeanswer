package forOffer;

import datastructure.TreeNode;

import java.util.*;

public class forOffer32_3 {
    /*Description
    * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，
    * 第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
    * */

    public List<List<Integer>> levelOrder(TreeNode root) {
        boolean reverse=false;
        List<List<Integer>> result=new ArrayList<>();
        if(root==null)
            return result;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> list=new ArrayList<>();
            while(size-->0){
                TreeNode cur=q.poll();
                list.add(cur.val);
                if(cur.left!=null)
                    q.add(cur.left);
                if(cur.right!=null)
                    q.add(cur.right);
            }
            if(reverse){
                Collections.reverse(list);
            }
            reverse=!reverse;
            result.add(list);
        }
        return result;

    }


}
