package leetcode.leetcode1;

import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode99 {
    /*Description
    * 给你二叉搜索树的根节点 root ，该树中的两个节点被错误地交换。请在不改变其结构的情况下，恢复这棵树。
    * 进阶：使用 O(n) 空间复杂度的解法很容易实现。你能想出一个只使用常数空间的解决方案吗？
    * */
    public void recoverTree(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        preOrder(root,list);
        int[] num=getDiff(list);
        change(num[0],num[1],root);
    }

    private void change(int i,int j,TreeNode cur){
        if(cur==null)
            return;
        if(cur.val==i)
            cur.val=j;
        else if(cur.val==j)
            cur.val=i;
        change(i,j,cur.left);
        change(i,j,cur.right);
    }

    private int[] getDiff(List<Integer> list){
        int[] result=new int[2];
        for(int i=0;i<list.size()-1;i++){
            if(list.get(i)>list.get(i+1)){
                result[0]=list.get(i);
                break;
            }
        }
        for(int j=list.size()-1;j>=1;j--){
            if(list.get(j)<list.get(j-1)){
                result[1]=list.get(j);
                break;
            }
        }
        return result;
    }

    private void preOrder(TreeNode node, List<Integer> list){
        if(node!=null){
            preOrder(node.left,list);
            list.add(node.val);
            preOrder(node.right,list);
        }
    }

    public static void main(String[] args){
        Integer[] num=new Integer[]{1,2,3,4,5,8,7};
        List<Integer> list= Arrays.asList(num);
        int[] res=new Leetcode99().getDiff(list);
        System.out.println(Arrays.toString(res));
    }
}
