package leetcode.leetcode21;

import java.util.TreeMap;

public class Leetcode2073 {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int result=0;
        for(int i=0;i<=k;i++){
            result+=Math.min(tickets[i],tickets[k]);
        }
        for(int i=k+1;i<tickets.length;i++)
            result+=Math.min(tickets[i]-1,tickets[k]);
        return result;
    }
}
