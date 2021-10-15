package leetcode.leetcode16;

import java.util.Stack;

public class Leetcode1544 {
    public String makeGood(String s) {
        StringBuilder sb=new StringBuilder();
        int length=s.length();
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<length;i++){
            char cur=s.charAt(i);
            if(!stack.isEmpty()&&(cur-'a'==stack.peek()-'A'||cur-'A'==stack.peek()-'a'))
                stack.pop();
            else
                stack.add(cur);
        }
        for(char cur:stack)
            sb.append(cur);
        return sb.toString();
    }
}
