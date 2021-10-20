package forOffer2;

import apple.laf.JRSUIUtils;
import datastructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ForOffer43 {

    class CBTInserter {

        boolean left=true;
        Queue<TreeNode> s;
        TreeNode root;
        public CBTInserter(TreeNode root) {
            this.root=root;
            s=new LinkedList<>();
            if(root!=null) {
                s.add(root);
                while (!s.isEmpty()) {
                    if (s.peek().left==null){
                        break;
                    }else if(s.peek().right==null){
                        left=false;
                        break;
                    }else{
                        TreeNode cur=s.poll();
                        s.add(cur.left);
                        s.add(cur.right);
                    }
                }
            }
        }

        public int insert(int v) {
            int res=0;
            if(root==null){
                root=new TreeNode(v);
                s.add(root);
            }else{
                if(left){
                    s.peek().left=new TreeNode(v);
                    res=s.peek().val;
                }else{
                    TreeNode cur=s.poll();
                    cur.right=new TreeNode(v);
                    s.add(cur.left);
                    s.add(cur.right);
                    res=cur.val;
                }
                left=!left;
            }
            return res;
        }

        public TreeNode get_root() {
            return root;
        }
    }
}
