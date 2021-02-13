package leetcode6;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leetcode559 {
    /*Description
    * 给定一个 N 叉树，找到其最大深度。
    * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
    * N 叉树输入按层序遍历序列化表示，每组子节点由空值分隔（请参见示例）。
    * */

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public int maxDepth(Node root) {
        int result=0;
        Queue<Node> q=new LinkedList<>();
        if(root!=null)
            q.add(root);
        while(!q.isEmpty()){
            result++;
            int size=q.size();
            for(int i=0;i<size;i++){
                Node cur=q.poll();
                if(cur.children!=null){
                    q.addAll(cur.children);
                }
            }
        }
        return result;
    }
}
