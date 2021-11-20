package leetcode.leetcode18;

public class Leetcode1784 {

    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        long[] sum=new long[candiesCount.length+1];
        for(int i=0;i<candiesCount.length;i++)
            sum[i+1]=sum[i]+candiesCount[i];

        boolean[] res=new boolean[queries.length];
        int index=0;
        for(int[] query:queries){
            if(sum[query[0]+1]>query[1]&&query[2]!=0&&sum[query[0]]/query[2]<=query[1])
                res[index]=true;

            index++;
        }
        return res;
    }
}
