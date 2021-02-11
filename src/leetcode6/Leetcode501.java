package leetcode6;

import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode501 {
    /*Description
    * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
    * 假定 BST 有如下定义：
    * 结点左子树中所含结点的值小于等于当前结点的值
    * 结点右子树中所含结点的值大于等于当前结点的值
    * 左子树和右子树都是二叉搜索树
    * */

    int maxTime=0;
    List<Integer> result=new ArrayList<>();
    List<Integer> list=new ArrayList<>();
    public int[] findMode(TreeNode root) {
        inOrder(root);
        int size=list.size();
        for(int i=0;i<size;i++){
            int curVal=list.get(i);
            int curTime=1;
            while(i<size-1&&list.get(i+1)==curVal){
                i++;
                curTime++;
            }
            if(curTime>maxTime) {
                result = new ArrayList<>();
                maxTime=curTime;
            }
            if(curTime==maxTime){
                result.add(curVal);
            }
        }
        int[] res=new int[result.size()];
        for(int i=0;i<res.length;i++)
            res[i]=result.get(i);
        return res;
    }

    private void inOrder(TreeNode cur){
        if(cur!=null) {
            inOrder(cur.left);
            list.add(cur.val);
            inOrder(cur.right);
        }
    }
}
