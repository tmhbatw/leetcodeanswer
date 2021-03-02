package forOffer;

import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class forOffer32_1 {
    /*Description
    *从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
    * */

    public int[] levelOrder(TreeNode root) {
        if(root==null)
            return new int[]{};
        List<Integer> list=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){
                TreeNode cur=q.poll();
                list.add(cur.val);
                if(cur.left!=null)
                    q.add(cur.left);
                if(cur.right!=null)
                    q.add(cur.right);
            }
        }
        int[] res=new int[list.size()];
        for(int i=0;i<list.size();i++)
            res[i]=list.get(i);
        return res;
    }
}
