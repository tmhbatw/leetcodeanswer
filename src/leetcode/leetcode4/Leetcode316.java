package leetcode.leetcode4;

import java.util.Stack;

public class Leetcode316 {

    //abcacb
    //ababc
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack=new Stack<>();
        int[] num=new int[26];
        boolean[] reached=new boolean[26];

        for(int i=0;i<s.length();i++){
            num[s.charAt(i)-'a']++;
        }
        for(int i=0;i<s.length();i++){
            char cur=s.charAt(i);

            if(reached[cur-'a']){
                num[cur-'a']--;
                continue;
            }

            while(!stack.isEmpty()&&stack.peek()>cur&&num[stack.peek()-'a']>1){
                num[stack.peek()-'a']--;
                reached[stack.pop()-'a']=false;
            }
            stack.add(cur);
            reached[cur-'a']=true;
        }

        StringBuilder sb=new StringBuilder();
        for(char cur:stack)
            sb.append(cur);
        return sb.toString();
    }
}
