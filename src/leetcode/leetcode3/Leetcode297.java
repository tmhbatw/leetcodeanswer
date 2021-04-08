package leetcode.leetcode3;

import datastructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode297 {
    /*Description
    * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，
    * 同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
    * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，
    * 你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
    * 提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅LeetCode 序列化二叉树的格式。
    * 你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
    * */
    public class Codec {
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb=new StringBuilder();
            if(root==null){
                return sb.toString();
            }
            Queue<TreeNode> q=new LinkedList<>();
            q.add(root);
            while(!q.isEmpty()){
                int size=q.size();
                for(int i=0;i<size;i++){
                    TreeNode cur=q.poll();
                    if(cur==null)
                        sb.append(-1001).append(" ");
                    else{
                        sb.append(cur.val).append(" ");
                        q.add(cur.left);
                        q.add(cur.right);
                    }
                }
            }
            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if(data==null||data.length()==0)
                return null;
            String[] n=data.split(" ");
            Queue<TreeNode> q=new LinkedList<>();
            TreeNode result=new TreeNode(Integer.parseInt(n[0]));
            int index=1;
            int length=n.length;
            TreeNode cur=result;
            boolean left=true;
            while(index<length){
                int curVal=Integer.parseInt(n[index++]);
                TreeNode child=(curVal==-1001?null:new TreeNode(curVal));
                if(child!=null){
                    q.add(child);
                }
                if(left){
                    cur.left=child;
                    left=false;
                }else{
                    left=true;
                    cur.right=child;
                    cur=q.poll();
                }
            }
            return result;
        }
    }
}
