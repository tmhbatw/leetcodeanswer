package leetcode.leetcode11;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Leetcode1054 {

    public int[] rearrangeBarcodes(int[] barcodes) {
        Arrays.sort(barcodes);
        PriorityQueue<int[]> q=new PriorityQueue<>((o1,o2)->{
            return o2[1]-o1[1];
        });
        for(int i=0;i<barcodes.length;i++){
            int start = i;
            while(i<barcodes.length-1&&barcodes[i+1]==barcodes[i])
                i++;
            q.add(new int[]{barcodes[i],i-start+1});
        }

        int index=0;
        int pre= -1;
        while(!q.isEmpty()){
            int[] first=q.poll();
            if(first[0]==pre){
                int[] next=q.poll();
                pre =next[0];
                barcodes[index++]=next[0];
                next[1]--;
                if (next[1]>0)
                    q.add(next);
                q.add(first);
            }else{
                barcodes[index++]=first[0];
                pre=first[0];
                first[1]--;
                if(first[1]>0){
                    q.add(first);
                }
            }
        }

        return barcodes;
    }

}
