package leetcode.leetcode9;

import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode894 {

    Map<Integer,List<TreeNode>> map=new HashMap<>();
    public List<TreeNode> allPossibleFBT(int n) {
        if(map.containsKey(n))
            return map.get(n);
        List<TreeNode> result=new ArrayList<>();
        if(n==1){
            result.add(new TreeNode(0));
            map.put(0,result);
            return result;
        }
        for(int i=1;i<n-1;i+=2){
            List<TreeNode> left=allPossibleFBT(i);
            List<TreeNode> right=allPossibleFBT(n-i-1);
            for(TreeNode l:left){
                for(TreeNode r:right){
                    TreeNode cur=new TreeNode(0);
                    cur.left=l;
                    cur.right=r;
                    result.add(cur);
                }
            }
        }
        map.put(n,result);
        return result;
    }
}
