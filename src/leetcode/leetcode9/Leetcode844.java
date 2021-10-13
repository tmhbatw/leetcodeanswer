package leetcode.leetcode9;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class Leetcode844 {

    public boolean backspaceCompare(String s, String t) {
        return getRes(s).equals(getRes(t));
    }

    private String getRes(String s){
        Deque<Character> dq=new ArrayDeque<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='#'){
                if(!dq.isEmpty())
                    dq.pollLast();
            }else
                dq.addLast(s.charAt(i));
        }
        StringBuilder sb=new StringBuilder();
        while(!dq.isEmpty())
            sb.append(dq.pollFirst());
        return sb.toString();
    }
}
