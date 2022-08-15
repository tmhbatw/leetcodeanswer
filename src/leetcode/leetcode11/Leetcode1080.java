package leetcode.leetcode11;

import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode1080 {

    Map<TreeNode, Boolean> map = new HashMap<>();
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        dfs(root,0,limit,new ArrayList<>());
        if(!map.get(root))
            return null;

        cutTree(root);
        return root;
    }

    private void cutTree(TreeNode root){
        if(root.left==null||!map.get(root.left))
            root.left=null;
        else
            cutTree(root.left);

        if(root.right==null||!map.get(root.right))
            root.right=null;
        else
            cutTree(root.right);
    }

    private void dfs(TreeNode root, int cur, int limit, List<TreeNode> list){
        map.put(root,false);
        cur+=root.val;
        if(root.left==null&&root.right==null&&cur>=limit){
            for(TreeNode node:list){
                map.put(node,true);
            }
            map.put(root,true);
        }

        List<TreeNode> newList=new ArrayList<>(list);
        if(root.left!=null){
            list.add(root);
            dfs(root.left,cur,limit,list);
        }
        if(root.right!=null){
            newList.add(root);
            dfs(root.right,cur,limit,newList);
        }
    }


}
