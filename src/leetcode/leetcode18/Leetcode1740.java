package leetcode.leetcode18;

import datastructure.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Leetcode1740 {

    TreeNode pp;
    TreeNode qq;
    int p,q;
    Map<TreeNode,TreeNode> map=new HashMap<>();
    public int findDistance(TreeNode root, int p, int q) {
        this.p=p;
        this.q=q;
        dfs(root);
        Map<TreeNode,Integer> m=new HashMap<>();
        int distance=1;
        System.out.println(qq.val+" "+pp.val);
        while(map.containsKey(pp)){
            m.put(pp,distance++);
            pp=map.get(pp);
        }
        int result=0;
        while(!m.containsKey(qq)){
            result++;
            qq=map.get(qq);
        }
        return result+m.get(qq);
    }

    private void dfs(TreeNode root){
        if(root==null)
            return;
        if(root.val==p)
            this.pp=root;
        if(root.val==q)
            this.qq=root;
        if(root.left!=null) {
            map.put(root.left, root);
            dfs(root.left);
        }
        if(root.right!=null){
            map.put(root.right,root);
            dfs(root.right);
        }
    }
}
