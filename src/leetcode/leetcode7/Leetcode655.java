package leetcode.leetcode7;

import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leetcode655 {

    public List<List<String>> printTree(TreeNode root) {
        int row=getLength(root);
        int col= (int) (Math.pow(2,row)-1);
        String[][] res=new String[row][col];

        Queue<TreeNode> q1=new LinkedList<>();
        Queue<int[]> q2=new LinkedList<>();

        q1.add(root);
        q2.add(new int[]{0,col-1});

        int i=0;
        while(!q1.isEmpty()){
            int size=q1.size();

            while(size-->0){
                TreeNode node=q1.poll();
                int[] num=q2.poll();

                int mid=(num[0]+num[1])/2;
                res[i][mid]=node.val+"";

                if(node.left!=null){
                    q1.add(node.left);
                    q2.add(new int[]{num[0],mid-1});
                }
                if(node.right!=null){
                    q1.add(node.right);
                    q2.add(new int[]{mid+1,num[1]});
                }
            }
            i++;
        }
        List<List<String>> result=new ArrayList<>();
        for(String[] cur:res){
            List<String> list=new ArrayList<>();
            for(String c:cur)
                list.add(c==null?"":c);
            result.add(list);
        }
        return result;
    }


    private int getLength(TreeNode root){
        if(root==null)
            return 0;
        return 1+Math.max(getLength(root.left),getLength(root.right));
    }
}
