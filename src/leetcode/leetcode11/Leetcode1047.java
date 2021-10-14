package leetcode.leetcode11;

import java.util.Stack;

public class Leetcode1047 {

    public String removeDuplicates(String s) {
        Stack<Character> a=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(!a.isEmpty()&&a.peek()==s.charAt(i))
                a.pop();
            else
                a.add(s.charAt(i));
        }
        StringBuilder sb=new StringBuilder();
        for(char cur:a)
            sb.append(cur);
        return sb.toString();
    }

    public static void main(String[] args){
        Stack<Integer> s=new Stack<>();
        s.add(1);
        s.add(2);
        for(int cur:s)
            System.out.println(cur);
    }
}
