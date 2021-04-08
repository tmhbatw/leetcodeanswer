package leetcode.leetcode2;

import datastructure.Node;

public class Leetcode116 {
    /*Description
    * 给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
    * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
    * 初始状态下，所有next 指针都被设置为 NULL。
    * 进阶：
    * 你只能使用常量级额外空间。
    * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
    * */

    public Node connect(Node root) {
        if(root==null)
            return null;
        Node left=root;
        int nodeNumber=1;
        while(left.left!=null){
            nodeNumber*=2;
            Node cur=left;
            while(cur.next!=null){
                cur.left.next=cur.right;
                cur.right.next=cur.next.left;
                cur=cur.next;
            }
            cur.left.next=cur.right;
            left=left.left;
        }
        return root;
    }
}
