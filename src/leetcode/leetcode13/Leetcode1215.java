package leetcode.leetcode13;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leetcode1215 {

    public List<Integer> countSteppingNumbers(int low, int high) {
        List<Integer> list=new ArrayList<>();
        if(low==0)
            list.add(0);

        Queue<Integer> q=new LinkedList<>();
        for(int i=1;i<=9;i++)
            q.add(i);
        while(!q.isEmpty()){
            int cur=q.poll();
            if(cur>high)
                continue;

            if(cur>=low)
                list.add(cur);
            if(cur<=200000000) {
                for (int last : getRes(cur % 10))
                    q.add(cur*10+last);
            }
        }
        return list;
    }

    private int[] getRes(int cur){
        if(cur==9)
            return new int[]{8};
        if(cur==0)
            return new int[]{1};
        return new int[]{cur-1,cur+1};
    }
}
