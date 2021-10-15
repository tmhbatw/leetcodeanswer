package leetcode.leetcode13;

public class Leetcode1252 {
    public int oddCells(int m, int n, int[][] indices) {
        int[][] res=new int[m][n];
        for(int[] cur:indices){
            for(int i=0;i<m;i++)
                res[i][cur[1]]++;
            for(int j=0;j<n;j++)
                res[cur[0]][j]++;
        }
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(res[i][j]%2==1)
                    count++;
            }
        }
        return count;
    }
}
