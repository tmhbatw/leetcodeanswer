package leetcode.leetcode24;

import datastructure.TreeNode;

public class Leetcode2313 {


    public int minimumFlips(TreeNode root, boolean result) {
        int[] res = getRes(root);
        return result ? res[1] : res[0];
    }

    //res[0]->false,res[1]->true
    private int[] getRes(TreeNode root) {
        if (root == null)
            return new int[]{0, 0};
        if (root.val == 0)
            return new int[]{0, 1};
        if (root.val == 1)
            return new int[]{1, 0};

        int[] l = getRes(root.left);
        int[] r = getRes(root.right);

        if (root.val == 2) { //or
            return new int[]{l[0] + r[0], Math.min(l[1], r[1])};
        }
        if (root.val == 3) {//and
            return new int[]{Math.min(l[0], r[0]), l[1] + r[1]};
        }
        if (root.val == 4) { //xor
            return new int[]{Math.min(l[0] + r[0], l[1] + r[1]), Math.min(l[0] + r[1], l[1] + r[0])};
        }
        //not
        if (root.left != null)
            return new int[]{l[1], l[0]};
        return new int[]{r[1], r[0]};
    }


}
