package leetcode.leetcode2;

import datastructure.ListNode;
import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode109 {
    /*Description
    * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
    * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
    * */

    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> list=new ArrayList<>();
        while(head!=null) {
            list.add(head.val);
            head = head.next;
        }
        return changeBST(list,0,list.size()-1);
    }

    private TreeNode changeBST(List<Integer> list,int start,int end){
        if(start>end)
            return null;
        if(start==end)
            return new TreeNode(list.get(start));
        int mid=(start+end)/2;
        TreeNode cur=new TreeNode(list.get(mid));
        cur.left=changeBST(list,start,mid-1);
        cur.right=changeBST(list,mid+1,end);
        return cur;
    }
}
