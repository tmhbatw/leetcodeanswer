package leetcode.leetcode14;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode1306 {

    public boolean canReach(int[] arr, int start) {
        int n=arr.length;
        if(arr[start]==0)
            return true;
        boolean[] reached=new boolean[n];

        reached[start]=true;
        Queue<Integer> q=new LinkedList<>();
        q.add(start);

        while(!q.isEmpty()){
            int cur=q.poll();

            int n1=cur+arr[cur];
            if(n1<n&&!reached[n1]){
                if(arr[n1]==0)
                    return true;
                q.add(n1);
                reached[n1]=true;
            }

            int n2=cur-arr[cur];
            if(n2>=0&&!reached[n2]){
                if(arr[n2]==0)
                    return true;
                q.add(n2);
                reached[n2]=true;
            }
        }

        return false;
    }
}
