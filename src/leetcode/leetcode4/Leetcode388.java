package leetcode.leetcode4;

import sun.misc.ASCIICaseInsensitiveComparator;

import java.util.Arrays;
import java.util.Stack;

public class Leetcode388 {

    public int lengthLongestPath(String input) {
        String[] s=input.split("\n");

        Stack<Integer> s1=new Stack<>();
        Stack<Integer> s2=new Stack<>();
        int result=0;

        for(String ss:s){
            int index=0;
            while(ss.charAt(index)=='\t')
                index++;
            String curS=ss.substring(index);
            while(!s2.isEmpty()&&s2.peek()>=index){
                s2.pop();
                s1.pop();
            }
            int curLength=(s1.isEmpty()?0:s1.peek())+curS.length()+1;

            if(curS.contains("."))
                result=Math.max(result,curLength);
            s1.add(curLength);
            s2.add(index);
        }
        return Math.max(0,result-1);
    }
}
