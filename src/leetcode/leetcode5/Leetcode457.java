package leetcode.leetcode5;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode457 {

    public boolean circularArrayLoop(int[] nums) {
        int length=nums.length;
        boolean[] reached=new boolean[length];
        for(int i=0;i<nums.length;i++){
            if(reached[i])
                continue;

            boolean[] cur=new boolean[nums.length];
            Queue<Integer> q=new LinkedList<>();
            cur[i]=true;
            boolean add=nums[i]>0;
            int index=i;
            while(true){
                if((nums[index]>0)!=add||Math.abs(nums[index])%length==0)
                    break;
                q.add(index);
                index=(index+nums[index])%length;
                if(index<0)
                    index+=length;
                if(reached[index])
                    break;
                if(cur[index])
                    return true;
                cur[index]=true;
            }

            for(int ii:q)
                reached[ii]=true;
        }
        return false;
    }

}
