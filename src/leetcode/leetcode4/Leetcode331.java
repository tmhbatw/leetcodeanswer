package leetcode.leetcode4;

public class Leetcode331 {
    /*Description
    * 序列化二叉树的一种方法是使用前序遍历。当我们遇到一个非空节点时，我们可以记录下这个节点的值。
    * 如果它是一个空节点，我们可以使用一个标记值记录，例如 #。
    * */

    public boolean isValidSerialization(String preorder) {
        String[] p=preorder.split(",");
        int slots=1;
        for(String cur:p){
            if(slots==0)
                return false;
            if(cur.equals("#"))
                slots--;
            else
                slots++;
        }
        return slots==0;
    }
}
