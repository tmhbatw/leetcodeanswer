package leetcode.leetcode4;

import java.util.Stack;

public class Leetcode394 {

    public String decodeString(String s) {
        Stack<String> s1=new Stack<>();
        Stack<Integer> s2=new Stack<>();

        int length=s.length();
        for(int i=0;i<length;i++){
            char cur=s.charAt(i);
            if(cur<='9'&&cur>='0'){
                int num=cur-'0';
                while(i<length-1&&s.charAt(i+1)<='9'&&s.charAt(i+1)>='0'){
                    num=num*10+s.charAt(++i)-'0';
                }
                s2.add(num);
            }
            if(cur<='z'&&cur>='a'){
                StringBuilder curr=new StringBuilder();
                curr.append(cur);
                while(i<length-1&&s.charAt(i+1)<='z'&&s.charAt(i+1)>='a')
                    curr.append(s.charAt(++i));
                s1.add(curr.toString());
            }
            if(cur=='[')
                s1.add("[");
            if(cur==']'){
                int time=s2.isEmpty()?1: s2.pop();
                String sb="";
                while(!s1.peek().equals("["))
                    sb=s1.pop()+sb;
                s1.pop();
                StringBuilder curSb=new StringBuilder();
                while(time-->0) {
                    curSb.append(sb);
                }
                s1.add(curSb.toString());
            }
        }

        StringBuilder result=new StringBuilder();
        for(String cur:s1)
            result.append(cur);
        return result.toString();
    }
}
