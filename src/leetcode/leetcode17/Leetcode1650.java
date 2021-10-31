package leetcode.leetcode17;

import java.util.HashSet;
import java.util.Set;

public class Leetcode1650 {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    };

    public Node lowestCommonAncestor(Node p, Node q) {
        Set<Node> set=new HashSet<>();
        set.add(p);
        while(p.parent!=null){
            set.add(p.parent);
            p=p.parent;
        }
        set.add(null);
        while(!set.contains(q)){
            q=q.parent;
        }
        return q;
    }
}
