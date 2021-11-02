package leetcode.leetcode17;

import java.util.HashMap;
import java.util.Map;

public class Leetcode1612 {
    class Node {
        char val;
        Node left;
        Node right;
        Node() {this.val = ' ';}
        Node(char val) { this.val = val; }
        Node(char val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean checkEquivalence(Node root1, Node root2) {
        Map<Character,Integer> map1=new HashMap<>();
        dfs(root1,map1);
        Map<Character,Integer> map2=new HashMap<>();
        dfs(root2,map2);
        if(map1.size()!=map2.size())
            return false;
        for(char key:map1.keySet()){
            if(!map2.containsKey(key)|| !map1.get(key).equals(map2.get(key)))
                return false;
        }
        return true;
    }

    private void dfs(Node root,Map<Character,Integer> map){
        if(root==null)
            return ;
        if(root.val=='+'){
            dfs(root.left,map);
            dfs(root.right,map);
        }
        else{
            map.put(root.val,map.getOrDefault(root.val,0)+1);
        }
    }
}
