package leetcode6;

public class Leetcode547 {
    /*Description
    * 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，
    * 且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。
    * 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
    * 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，
    * 而 isConnected[i][j] = 0 表示二者不直接相连。返回矩阵中 省份 的数量。
    * */

    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        boolean[] reached=new boolean[n];
        int result=0;
        for(int i=0;i<n;i++){
            if(reached[i])
                continue;
            result++;
            recursion(i,isConnected,reached);
        }
        return result;
    }

    private void recursion(int cur,int[][] isConnected,boolean[] reached){
        reached[cur]=true;
        int[] neighbor=isConnected[cur];
        for(int i=0;i<neighbor.length;i++){
            if(neighbor[i]==1){
                if(!reached[i])
                    recursion(i,isConnected,reached);
            }
        }
    }
}
