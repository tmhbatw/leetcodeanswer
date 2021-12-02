package leetcode.leetcode16;

import datastructure.TreeNode;

import java.util.Stack;

public class Leetcode1586 {

    class BSTIterator {
        Stack<Integer> s1=new Stack<>();
        Stack<Integer> s2=new Stack<>();
        Stack<TreeNode> s3=new Stack<>();
        int cur=-1;
        public BSTIterator(TreeNode root) {
            while(root!=null){
                s3.add(root);
                root=root.left;
            }
        }

        public boolean hasNext() {
            return !s2.isEmpty()||!s3.isEmpty();
        }

        public int next() {
            if(!s2.isEmpty()){
                s1.add(cur);
                cur=s2.pop();
                return cur;
            }else{
                TreeNode cur=s3.pop();
                if(this.cur!=-1)
                    s1.add(this.cur);

                this.cur=cur.val;
                cur=cur.right;
                while(cur!=null){
                    s3.add(cur);
                    cur=cur.left;
                }
                return this.cur;
            }
        }

        public boolean hasPrev() {
            return !s1.isEmpty();
        }

        public int prev() {
            s2.add(cur);
            cur=s1.pop();
            return cur;
        }
    }
}
