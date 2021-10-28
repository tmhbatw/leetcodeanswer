package leetcode.leetcode5;

import datastructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Leetcode449 {

    class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if(root==null)
                return "#";
            StringBuilder sb=new StringBuilder();
            Queue<TreeNode> s=new LinkedList<>();
            s.add(root);
            while(!s.isEmpty()){
                TreeNode cur=s.poll();
                if(cur==null)
                    sb.append(",").append("#");
                else{
                    sb.append(",").append(cur.val);
                    s.add(cur.left);
                    s.add(cur.right);
                }
            }
            return sb.substring(1);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if(data.equals("#"))
                return null;
            String[] val=data.split(",");
            TreeNode root=new TreeNode(Integer.parseInt(val[0]));
            Queue<TreeNode> q=new LinkedList<>();
            q.add(root);
            int index=1;
            boolean left=true;
            while(!q.isEmpty()){
                TreeNode cur=val[index].equals("#")?null:
                        new TreeNode(Integer.parseInt(val[index]));
                index++;
                if(left){
                    q.peek().left=cur;
                }else{
                    q.poll().right=cur;
                }
                left=!left;
                if(cur!=null)
                    q.add(cur);
            }

            return root;
        }
    }
}
