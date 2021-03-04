package interview;

import datastructure.ListNode;
import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem4_3 {
    /*Description
    * 给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表（比如，若一棵树的深度为 D，
    * 则会创建出 D 个链表）。返回一个包含所有深度的链表的数组。
     * */

    public ListNode[] listOfDepth(TreeNode tree) {
        List<ListNode> list=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.add(tree);
        while(!q.isEmpty()){
            ListNode result=new ListNode(0);
            ListNode cur=result;
            int size=q.size();
            while(size-->0){
                TreeNode node=q.poll();
                cur.next=new ListNode(node.val);
                cur=cur.next;
                if(node.left!=null)
                    q.add(node.left);
                if(node.right!=null)
                    q.add(node.right);
            }
            list.add(result.next);
        }
        ListNode[] result=new ListNode[list.size()];
        for(int i=0;i<list.size();i++)
            result[i]=list.get(i);
        return result;
    }
}
