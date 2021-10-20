package forOffer2;

import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ForOffer48 {

    public class Codec {
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if(root==null)
                return "";
            StringBuilder sb=new StringBuilder();
            Queue<TreeNode> q=new LinkedList<>();
            q.add(root);
            while(!q.isEmpty()){
                TreeNode cur=q.poll();
                if(cur==null){
                    sb.append(" ").append("#");
                    continue;
                }
                sb.append(" ").append(cur.val);
                q.add(cur.left);
                q.add(cur.right);
            }
            System.out.println(sb.toString());
            return sb.substring(1);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if(data.length()==0)
                return null;
            String[] s=data.split(" ");
            TreeNode root=new TreeNode(Integer.parseInt(s[0]));
            Queue<TreeNode> q=new LinkedList<>();
            q.add(root);
            boolean left=true;
            int index=1;
            while(!q.isEmpty()){
                TreeNode cur=s[index].equals("#")?
                        null:new TreeNode(Integer.parseInt(s[index]));
                if(left){
                    q.peek().left=cur;
                }else{
                    q.poll().right=cur;
                }
                left=!left;
                index++;
                if(cur!=null)
                    q.add(cur);
            }
            return root;
        }
    }
}
