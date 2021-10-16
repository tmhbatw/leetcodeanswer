package leetcode.leetcode18;

public class Leetcode1791 {
    public int findCenter(int[][] edges) {
        int n=0;
        for(int[] cur:edges){
            n=Math.max(cur[0],n);
            n=Math.max(cur[1],n);
        }
        int[] number=new int[n+1];
        for(int[] edge:edges){
            number[edge[0]]++;
            number[edge[1]]++;
        }
        for(int i=0;i<=n;i++){
            if(number[i]==n-1)
                return i;
        }
        return -1;
    }
}
