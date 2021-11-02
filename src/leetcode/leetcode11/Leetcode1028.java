package leetcode.leetcode11;

import datastructure.TreeNode;

import java.util.Stack;

public class Leetcode1028 {
    int start=0;
    public TreeNode recoverFromPreorder(String traversal) {
        TreeNode root=new TreeNode(getVal(traversal));
        int preDis=0;
        Stack<TreeNode> s=new Stack<>();
        s.add(root);
        while(start<traversal.length()){
            int dis=getDis(traversal);
            int val=getVal(traversal);
            if(dis>preDis){
                s.peek().left=new TreeNode(val);
                s.add(s.peek().left);
            }else{
                for(int i=0;i<=preDis-dis;i++)
                    s.pop();
                TreeNode node=s.peek();
                node.right=new TreeNode(val);
                s.add(node.right);
            }
            preDis=dis;
        }
        return root;
    }

    private int getVal(String t){
        int val=t.charAt(start)-'0';
        while(start<t.length()-1&&t.charAt(start+1)<='9'&&t.charAt(start+1)>='0')
            val=val*10+t.charAt(++start)-'0';
        start++;
        return val;
    }

    private int getDis(String t){
        int distance=1;
        while(start<t.length()-1&&t.charAt(start+1)=='-'){
            distance++;
            start++;
        }
        start++;
        return distance;
    }
}
