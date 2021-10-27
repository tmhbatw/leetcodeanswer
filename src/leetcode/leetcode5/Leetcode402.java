package leetcode.leetcode5;

import java.util.Stack;

public class Leetcode402 {

    public String removeKdigits(String num, int k) {
        Stack<Character> s=new Stack<>();
        for(int i=0;i<num.length();i++){
            char cur=num.charAt(i);
            while(!s.isEmpty()&&s.peek()>cur&&k>0){
                s.pop();
                k--;
            }
            s.add(cur);
        }
        while(k>0){
            k--;
            s.pop();
        }
        StringBuilder sb=new StringBuilder();
        for(char cur:s)
            sb.append(cur);
        int index=0;
        while(index<sb.length()&&sb.charAt(index)=='0')
            index++;
        return index==sb.length()?"0":sb.substring(index);
    }
}
