package leetcode2;

import datastructure.TreeNode;

import java.util.Stack;

public class Leetcode173 {
    /*Description
    * 实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。
    * 调用 next() 将返回二叉搜索树中的下一个最小的数。
    * */

    class BSTIterator {
        Stack<TreeNode> stack=new Stack<>();
        public BSTIterator(TreeNode root) {
            while(root!=null){
                stack.add(root);
                root=root.left;
            }
        }

        public int next() {
            TreeNode cur=stack.pop();
            TreeNode right=cur.right;
            while(right!=null){
                stack.add(right);
                right=right.left;
            }
            return cur.val;
        }

        public boolean hasNext() {
            return !stack.empty();
        }
    }
}
