package leetcode.leetcode7;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode649 {

    public String predictPartyVictory(String senate) {
        Queue<Integer> q1=new LinkedList<>();
        Queue<Integer> q2=new LinkedList<>();
        int length=senate.length();

        for(int i=0;i<length;i++){
            if(senate.charAt(i)=='R')
                q1.add(i);
            else
                q2.add(i);
        }

        while(!q1.isEmpty()&&!q2.isEmpty()){
            int val1=q1.poll();
            int val2=q2.poll();
            if(val1<val2){
                q1.add(val1+length);
            }else
                q2.add(val2+length);
        }

        return q1.isEmpty()?"Dire":"Radiant";
    }
}
