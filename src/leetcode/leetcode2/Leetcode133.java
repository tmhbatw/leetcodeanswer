package leetcode.leetcode2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode133 {
    /*Description
    * 给你无向 连通 图中一个节点的引用，请你返回该图的 深拷贝（克隆）。
    * 图中的每个节点都包含它的值 val（int） 和其邻居的列表（list[Node]）。
    * */

    Map<Integer,Node> map=new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node==null)
            return null;
        if(map.containsKey(node.val))
            return map.get(node.val);
        Node cur=new Node(node.val);
        List<Node> result=new ArrayList<>();
        cur.neighbors=result;
        map.put(node.val,cur);
        for(Node curr:node.neighbors)
            cur.neighbors.add(cloneGraph(curr));
        return cur;
    }
    //被测试用例坑了
/*
    private Node cloneGraph(Node node,Map<Integer,Node> map){
        if(map.containsKey(node.val))
            return map.get(node.val);
        Node result=new Node(node.val);
        List<Node> resNeighbors=new ArrayList<>();
        result.neighbors=resNeighbors;
        map.put(node.val,node);
        for(Node curr:node.neighbors){
            resNeighbors.add(cloneGraph(curr,map));
        }
        return result;
    }
*/

    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
