package leetcode1;

import java.util.Stack;

public class Leetcode20 {
    /*Description
    * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
    * */

    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            char cur=s.charAt(i);
            switch (cur){
                case '(':
                case '{':
                case '[':
                    stack.add(cur);
                    break;
                case ')':
                    if(stack.empty()||stack.pop()!='(')
                        return false;
                    break;
                case '}':
                    if(stack.empty()||stack.pop()!='{')
                        return false;
                    break;
                default:
                    if(stack.empty()||stack.pop()!='[')
                        return false;
            }
        }
        return stack.empty();
    }
}
