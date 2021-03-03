package forOffer;

import datastructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class forOffer37 {
    /*Description
    * 请实现两个函数，分别用来序列化和反序列化二叉树。
    * */

    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb=new StringBuilder();
            Queue<TreeNode> q=new LinkedList<>();
            q.add(root);
            while(!q.isEmpty()){
                TreeNode cur=q.poll();
                if(cur==null)
                    sb.append(" ").append("null");
                else{
                    sb.append(" ").append(cur.val);
                    q.add(cur.left);
                    q.add(cur.right);
                }
            }
            return sb.substring(1);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] val=data.split(" ");
            if(val.length==1)
                return null;
            TreeNode result=new TreeNode(Integer.parseInt(val[0]));
            Queue<TreeNode> q=new LinkedList<>();
            q.add(result);
            int index=1;
            while(index<val.length){
                TreeNode cur=q.poll();
                if(val[index].equals("null")){
                    index++;
                    cur.left=null;
                }else{
                    cur.left=new TreeNode(Integer.parseInt(val[index++]));
                    q.add(cur.left);
                }
                if(val[index].equals("null")){
                    index++;
                    cur.right=null;
                }else{
                    cur.right=new TreeNode(Integer.parseInt(val[index++]));
                    q.add(cur.right);
                }
            }
            return result;
        }
    }
}
