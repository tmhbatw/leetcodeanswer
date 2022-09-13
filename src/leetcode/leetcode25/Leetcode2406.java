package leetcode.leetcode25;

public class Leetcode2406 {

    public int minGroups(int[][] intervals) {
        int[] result=new int[1000001];
        for(int[] cur:intervals) {
            result[cur[0]]++;
            result[cur[1]+1]--;
        }

        int res = 0;
        for(int i=1;i<=1000000;i++){
            result[i]+=result[i-1];
            res=Math.max(result[i],res);
        }
        return res;
    }


}
