package leetcode.leetcode13;

import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode1261 {

    class FindElements {

        TreeNode root;
        public FindElements(TreeNode root) {
            dfs(root,0);
            this.root=root;
        }

        private void dfs(TreeNode root,int val){
            if(root==null)
                return;
            root.val=val;
            dfs(root.left,val*2+1);
            dfs(root.right,val*2+2);
        }

        public boolean find(int target) {
            List<Integer> list=new ArrayList<>();
            while(target>0){
                list.add(target);
                target=(target-1)/2;
            }
            TreeNode cur=root;
            for(int j=list.size()-1;j>=0;j--){
                if(list.get(j)%2==1){
                    if(cur.left==null)
                        return false;
                    cur=cur.left;
                }
                if(list.get(j)%2==0){
                    if(cur.right==null)
                        return false;
                    cur=cur.right;
                }
            }
            return true;
        }
    }
}
