package leetcode.leetcode12;

import java.util.Stack;

public class Leetcode1190 {
    public String reverseParentheses(String s) {
        Stack<String> stack=new Stack<>();
        int length=s.length();
        for(int i=0;i<length;i++){
            if(s.charAt(i)=='(')
                stack.add("(");
            else if(s.charAt(i)==')'){
                StringBuilder cur= new StringBuilder();
                while(!stack.peek().equals("(")){
                    cur.insert(0, stack.pop());
                }
                stack.pop();
                stack.add(cur.reverse().toString());
            }else{
                StringBuilder sb=new StringBuilder();
                sb.append(s.charAt(i));
                while(i<length-1&&s.charAt(i+1)!='('&&s.charAt(i+1)!=')')
                    sb.append(s.charAt(++i));
                stack.add(sb.toString());
            }
        }
        StringBuilder result=new StringBuilder();
        for(String cur:stack)
            result.append(cur);
        return result.toString();
    }
}
