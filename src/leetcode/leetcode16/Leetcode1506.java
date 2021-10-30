package leetcode.leetcode16;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Leetcode1506 {
    class Node {
        public int val;
        public List<Node> children;


        public Node() {
            children = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            children = new ArrayList<Node>();
        }

        public Node(int _val,ArrayList<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    public Node findRoot(List<Node> tree) {
        Set<Node> set=new HashSet<>();
        for(Node cur:tree)
            set.addAll(cur.children);

        for(Node cur:tree){
            if(!set.contains(cur))
                return cur;
        }
        return null;
    }
}
