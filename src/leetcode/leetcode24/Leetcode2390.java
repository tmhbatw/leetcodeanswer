package leetcode.leetcode24;

import java.util.Stack;

public class Leetcode2390 {

    public String removeStars(String s) {
        Stack<Character> ss=new Stack<>();
        for(char c:s.toCharArray()){
            if(c=='*')
                ss.pop();
            else
                ss.add(c);
        }
        StringBuilder sb=new StringBuilder();
        while(!ss.empty())
            sb.append(ss.pop());
        return sb.reverse().toString();
    }

}
