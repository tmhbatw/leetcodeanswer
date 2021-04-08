package leetcode.leetcode2;

import datastructure.Node;

public class Leetcode117 {
    /*Description
    *给定一个二叉树
    *填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
    * 初始状态下，所有next 指针都被设置为 NULL。
    * 进阶：
    * 你只能使用常量级额外空间。
    * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
    * */

    public Node connect(Node root) {
        if(root==null)
            return null;
        Node first=root;
        while(getNextLevelFirstNode(first)!=null){
            Node[] cur=getNextLevelFirstNode(first);
            Node father=cur[1],child=cur[0];
            while(getNext(father,child)!=null){
                Node[] curRes=getNext(father,child);
                child.next=curRes[0];
                child=child.next;
                father=curRes[1];
            }
            first=cur[0];
        }
        return root;
    }

    private Node[] getNext(Node father,Node child){
        if(father.left==child){
            if(father.right!=null)
                return new Node[]{father.right,father};
            if(father.next==null)
                return null;
            return getNext(father.next,child);
        }else if(father.right==child){
            if(father.next==null)
                return null;
            return getNext(father.next,child);
        }else{
            if(father.left!=null){
                return new Node[]{father.left,father};
            }
            if(father.right!=null){
                return new Node[]{father.right,father};
            }
            if(father.next!=null)
                return getNext(father.next,child);
            return null;
        }
    }

    private Node[] getNextLevelFirstNode(Node first){
        if(first.left!=null)
            return new Node[]{first.left,first};
        if(first.right!=null)
            return new Node[]{first.right,first};
        if(first.next==null)
            return null;
        return getNextLevelFirstNode(first.next);
    }
}
