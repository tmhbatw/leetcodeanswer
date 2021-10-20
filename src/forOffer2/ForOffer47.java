package forOffer2;

import datastructure.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class ForOffer47 {

    public TreeNode pruneTree(TreeNode root) {
        if(root==null)
            return null;

        Map<TreeNode,TreeNode> father=new HashMap<>();
        Map<TreeNode,Boolean> leftNode=new HashMap<>();

        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);

        Queue<TreeNode> p=new LinkedList<>();
        while(!q.isEmpty()){
            TreeNode cur=q.poll();
            if(cur.left!=null){
                father.put(cur.left,cur);
                leftNode.put(cur.left,true);
                q.add(cur.left);
            }
            if(cur.right!=null){
                father.put(cur.right,cur);
                leftNode.put(cur.right,false);
                q.add(cur.right);
            }
            if(cur.left==null&&cur.right==null){
                p.add(cur);
            }
        }


        System.out.println(father);
        System.out.println(leftNode);

        while(!p.isEmpty()){
            TreeNode cur=p.poll();
            if(father.containsKey(cur)){
                if(cur.left==null&&cur.right==null&&cur.val==0){
                    boolean left=leftNode.get(cur);
                    if(left){
                        father.get(cur).left=null;
                    }else
                        father.get(cur).right=null;
                    p.add(father.get(cur));
                }
            }
        }

        if(root.left==null&&root.right==null&&root.val==0)
            return null;
        return root;
    }
}
