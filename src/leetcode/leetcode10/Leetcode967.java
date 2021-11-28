package leetcode.leetcode10;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leetcode967 {

    public int[] numsSameConsecDiff(int n, int k) {
        Queue<Integer> q=new LinkedList<>();
        for(int i=1;i<=9;i++)
            q.add(i);

        while(--n>0){
            int size=q.size();
            while(size-->0){
                int cur=q.poll();
                int last=cur%10;

                if(last+k<=9){
                    q.add(cur*10+last+k);
                }
                if(k!=0&&last-k>=0)
                    q.add(cur*10+last-k);
            }
        }

        int[] res=new int[q.size()];
        int index=0;
        for(int cur:q){
            res[index++]=cur;
        }
        return res;
    }

}
