package leetcode.leetcode7;

import java.util.List;
import java.util.Stack;

public class Leetcode636 {

    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result=new int[n];

        int cur=-1;
        int pre=-1;
        Stack<Integer> s=new Stack<>();

        for(String log:logs){
            String[] ss=log.split(":");
            int number=Integer.parseInt(ss[0]);
            int time=Integer.parseInt(ss[2]);
            if(ss[1].equals("start")){
                if(cur==-1){
                    cur=number;
                }else{
                    result[cur]+=time-pre;
                    s.add(cur);
                    cur=number;
                }
                pre=time;
            }else{
                result[cur]+=time-pre+1;
                if(s.isEmpty()){
                    cur=-1;
                    pre=-1;
                }else{
                    cur=s.pop();
                    pre=time+1;
                }
            }
        }

        return result;
    }
}
