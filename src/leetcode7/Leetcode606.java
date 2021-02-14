package leetcode7;

import datastructure.TreeNode;

public class Leetcode606 {
    /*Description
    * 你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。
    * 空节点则用一对空括号 "()" 表示。而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。
    * */

    public String tree2str(TreeNode t) {
        StringBuilder sb=new StringBuilder();
        if(t==null)
            return sb.toString();
        sb.append(t.val);
        if(t.left==null&&t.right==null)
            return sb.toString();
        sb.append("(");
        if(t.left==null) {
            sb.append(")(").append(tree2str(t.right)).append(")");
            return sb.toString();
        }
        sb.append(tree2str(t.left)).append(")");
        if(t.right!=null){
            sb.append("(").append(tree2str(t.right)).append(")");
        }
        return sb.toString();
    }
}
