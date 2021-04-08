package leetcode.leetcode6;

import datastructure.TreeNode;

public class Leetcode536 {
    /*Description
    * 你需要从一个包括括号和整数的字符串构建一棵二叉树。
    * 输入的字符串代表一棵二叉树。它包括整数和随后的 0 ，1 或 2 对括号。整数代表根的值，一对括号内表示同样结构的子树。
    * 若存在左子结点，则从左子结点开始构建。
    * */
    public TreeNode str2tree(String s) {
        if(s==null||0==s.length())
            return null;
        int firstNumber=0;
        int index=0;
        boolean positive=true;
        if(s.charAt(0)=='-') {
            positive = false;
            index++;
        }
        while(index<s.length()){
            char cur=s.charAt(index);
            if(cur<='9'&&cur>='0') {
                firstNumber *= 10;
                firstNumber+=cur-'0';
                index++;
            }else{
                break;
            }
        }
        TreeNode result=new TreeNode(positive?firstNumber:-firstNumber);
        int startTime=index+1;
        if(index==s.length())
            return result;
        int leftTime=0;
        for(;index<s.length();index++){
            if(s.charAt(index)=='(')
                leftTime++;
            else if(s.charAt(index)==')')
                leftTime--;
            if(leftTime==0)
                break;
        }
        result.left=str2tree(s.substring(startTime,index));

        if(index==s.length()-1)
            return result;
        result.right=str2tree(s.substring(index+2,s.length()-1));
        return result;
    }
}
