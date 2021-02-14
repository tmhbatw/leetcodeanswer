package leetcode3;

import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Leetcode272 {
    /*Description
    * 给定一个不为空的二叉搜索树和一个目标值 target，请在该二叉搜索树中找到最接近目标值 target 的 k 个值。
    * 注意：
    * 给定的目标值 target 是一个浮点数
    * 你可以默认 k 值永远是有效的，即 k ≤ 总结点数
    * 题目保证该二叉搜索树中只会存在一种k 个值集合最接近目标值
    * */

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> list=new ArrayList<>();
        inOrder(root,list);
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                double oo1=Math.abs(o1-target);
                double oo2=Math.abs(o2-target);
                return oo1<oo2?-1:1;
            }
        });
        List<Integer> result=new ArrayList<>();
        for(int i=0;i<Math.min(k,list.size());i++)
            result.add(list.get(i));
        return result;
    }

    private void inOrder(TreeNode root, List<Integer> list){
        if(root!=null) {
            inOrder(root.left, list);
            list.add(root.val);
            inOrder(root.right, list);
        }
    }
}
