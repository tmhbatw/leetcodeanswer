package leetcode.leetcode16;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leetcode1522 {

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

        public Node(int _val, ArrayList<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    int result=0;
    public int diameter(Node root) {
        dfs(root);
        return result;
    }

    private int dfs(Node root){
        if(root==null)
            return 0;
        int first=0;
        int second=0;
        for(Node next:root.children){
            int n=dfs(next);
            if(n>first){
                second=first;
                first=n;
            }else if(n>second)
                second=n;
        }
        result=Math.max(first+second,result);
        return first+1;
    }
}
