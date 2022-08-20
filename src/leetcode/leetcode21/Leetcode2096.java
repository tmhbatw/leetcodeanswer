package leetcode.leetcode21;

import datastructure.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Leetcode2096 {

    Map<TreeNode,TreeNode> map;
    TreeNode start;
    TreeNode end;
    public String getDirections(TreeNode root, int startValue, int destValue) {
        this.map=new HashMap<>();
        dfs(root,startValue,destValue);

        Set<TreeNode> set=new HashSet<>();
        TreeNode node=end;
        set.add(node);
        while(map.containsKey(node)){
            node=map.get(node);
            set.add(node);
        }
        String result="";
        node=start;
        while(!set.contains(node)){
            node=map.get(node);
            result+="U";
        }

        while(true){
            if(set.contains(node.left)){
                node=node.left;
                result+="L";
            }else if(set.contains(node.right)){
                node=node.right;
                result+="R";
            }else{
                break;
            }
        }

        return result;
    }

    private void dfs(TreeNode cur,int start,int end){
        if(cur.val==start)
            this.start=cur;
        if(cur.val==end)
            this.end=cur;
        if(cur.left!=null){
            map.put(cur.left,cur);
            dfs(cur.left,start,end);
        }
        if(cur.right!=null){
            map.put(cur.right,cur);
            dfs(cur.right,start,end);
        }
    }
}
