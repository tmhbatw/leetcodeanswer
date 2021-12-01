package leetcode.leetcode13;

import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode1214 {

    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        List<Integer> list1=new ArrayList<>();
        dfs(root1,list1);
        List<Integer> list2=new ArrayList<>();
        dfs(root2,list2);
        int l=0,r=list2.size()-1;
        while(l<list1.size()&&r>=0){
            int cur=list1.get(l)+list2.get(r);
            if(cur==target)
                return true;
            if(cur<target)
                l++;
            else
                r--;
        }
        return false;
    }

    private void dfs(TreeNode node, List<Integer> list){
        if(node==null)
            return;
        dfs(node.left,list);
        list.add(node.val);
        dfs(node.right,list);
    }
}
