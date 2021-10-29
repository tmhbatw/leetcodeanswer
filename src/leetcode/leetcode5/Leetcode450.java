package leetcode.leetcode5;

import datastructure.TreeNode;

public class Leetcode450 {

    TreeNode father=null;
    TreeNode deleteNode=null;
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null)
            return null;

        if(root.val==key){
            deleteNode=root;
        }else {
            inOrder(root, key);
        }

        if(deleteNode==null)
            return root;
        if(deleteNode.left==null&&deleteNode.right==null){
            if(father==null)
                return null;
            if(father.left!=null&&father.left.val==key)
                father.left=null;
            else
                father.right=null;
            return root;
        }
        if(deleteNode.left==null){
            TreeNode right=deleteNode.right;
            if(right.left==null){
                deleteNode.val=right.val;
                deleteNode.right=right.right;
                return root;
            }
            TreeNode rightFather=deleteNode;
            while(right.left!=null){
                rightFather=right;
                right=right.left;
            }
            deleteNode.val=right.val;
            rightFather.left=right.right;
        }else{
            TreeNode left=deleteNode.left;
            if(left.right==null){
                deleteNode.val=left.val;
                deleteNode.left=left.left;
                return root;
            }
            TreeNode leftFather=deleteNode;
            while(left.right!=null){
                leftFather=left;
                left=left.right;
            }
            deleteNode.val=left.val;
            leftFather.right=left.left;
        }

        return root;
    }

    private void inOrder(TreeNode root,int key){
        if(deleteNode!=null)
            return;

        if(root.left!=null){
            if(root.left.val==key) {
                deleteNode = root.left;
                father = root;
                return;
            }else
                inOrder(root.left,key);
        }

        if(root.right!=null){
            if(root.right.val==key){
                deleteNode=root.right;
                father=root;
            }else{
                inOrder(root.right,key);
            }
        }
    }

}
