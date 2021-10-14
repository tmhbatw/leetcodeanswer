package leetcode.leetcode10;

public class Leetcode997 {


    public int findJudge(int n, int[][] trust) {
        int[] res=new int[n+1];
        boolean[] isJudge=new boolean[n+1];

        for(int[] cur:trust){
            res[cur[1]]++;
            isJudge[cur[0]]=true;
        }

        for(int i=1;i<=n;i++){
            if(!isJudge[i]&&res[i]==n-1)
                return i;
        }
        return -1;
    }
}
