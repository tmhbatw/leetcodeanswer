package leetcode.leetcode11;

import java.util.Stack;

public class Leetcode1003 {

    public boolean isValid(String s) {
        if(s.length()%3!=0)
            return false;
        Stack<Character> stack=new Stack<>();

        for(int i=0;i<s.length();i++){
            switch (s.charAt(i)){
                case 'a': case 'b':
                    stack.add(s.charAt(i));
                    break;
                default:
                    if(stack.isEmpty()||stack.pop()!='b')
                        return false;
                    if(stack.isEmpty()||stack.pop()!='a')
                        return false;
            }
        }
        return stack.isEmpty();
    }
}
