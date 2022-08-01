package leetcode.leetcode19;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode1871 {

    public boolean canReach(String s, int minJump, int maxJump) {
        if(s.charAt(s.length()-1)!='0')
            return false;
        Queue<Integer> q=new LinkedList<>();
        int start=0,end=0;
        q.add(0);
        while(!q.isEmpty()){
            int cur=q.poll();
            if(cur==s.length()-1)
                return true;
            start=Math.max(cur+minJump,end+1);
            end=Math.min(cur+maxJump,s.length() - 1);
            for(int j=start;j<=end;j++){
                if(s.charAt(j)=='0')
                    q.add(j);
            }
        }
        return false;
    }
}
