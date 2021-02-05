package leetcode3;

public class Leetcode261 {
    /*Description
    * 给定从 0 到 n-1 标号的 n 个结点，和一个无向边列表（每条边以结点对来表示），
    * 请编写一个函数用来判断这些边是否能够形成一个合法有效的树结构。
    * */

    public boolean validTree(int n, int[][] edges) {
        int[] dp=new int[n];
        for(int i=0;i<n;i++)
            dp[i]=i;
        for(int[] cur:edges){
            int type1=getType(cur[0],dp);
            int type2=getType(cur[1],dp);
            if(type1==type2)
                return false;
            dp[type2]=type1;
        }
        int type=getType(0,dp);
        for(int i=1;i<n;i++){
            if(type!=getType(i,dp))
                return false;
        }
        return true;
    }

    private int getType(int n,int[] dp){
        if(dp[n]!=n)
            return getType(dp[n],dp);
        return n;
    }
}
