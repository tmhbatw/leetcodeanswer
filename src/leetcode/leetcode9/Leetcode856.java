package leetcode.leetcode9;

import java.util.Stack;

public class Leetcode856 {

    public int scoreOfParentheses(String s) {
        Stack<String> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(')
                stack.add("(");
            else{
                String pre;
                int val=0;
                while(!(pre=stack.pop()).equals("(")){
                    val += Integer.parseInt(pre);
                }
                stack.add(val+"");
            }
        }
        int res=0;
        for(String cur:stack)
            res+=Integer.parseInt(cur);
        return res;
    }
}
