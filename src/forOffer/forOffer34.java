package forOffer;

import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class forOffer34 {
    /*Description
    * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
    * */

    List<List<Integer>> list;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        list=new ArrayList<>();
        if(root==null)
            return list;
        List<Integer> res=new ArrayList<>();
        res.add(root.val);
        recursion(root,new ArrayList<>(),0,sum);
        return list;
    }

    private void recursion(TreeNode root,List<Integer> res,int curSum,int sum){
        List<Integer> list=new ArrayList<>(res);
        list.add(root.val);
        curSum+=root.val;
        if(root.left==null&&root.right==null){
            if(curSum==sum) {
                this.list.add(list);
            }
        }
        if(root.left!=null){
            recursion(root.left,list,curSum,sum);
        }
        if(root.right!=null)
            recursion(root.right,list,curSum,sum);
    }
}
