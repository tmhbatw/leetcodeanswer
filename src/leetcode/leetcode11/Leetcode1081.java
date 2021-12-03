package leetcode.leetcode11;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Leetcode1081 {

    public String smallestSubsequence(String s) {
        int[] num=new int[26];
        for(char c:s.toCharArray()){
            num[c-'a']++;
        }

        Stack<Character> stack=new Stack<>();
        Set<Character> set=new HashSet<>();

        for(char c:s.toCharArray()){
            num[c-'a']--;
            if(set.contains(c))
                continue;

            while(!stack.isEmpty()&&stack.peek()>c&&num[stack.peek()]>0)
                set.remove(stack.pop());

            stack.add(c);
            set.add(c);
        }
        StringBuilder sb=new StringBuilder();
        for(char c:stack)
            sb.append(c);
        return sb.toString();
    }
}
