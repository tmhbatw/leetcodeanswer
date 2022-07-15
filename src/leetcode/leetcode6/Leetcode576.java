package leetcode.leetcode6;

public class Leetcode576 {

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][] cur=new int[m][n];
        int mod=1000000007;
        int result=0;

        cur[startRow][startColumn]=1;
        int[][] next=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        while(maxMove-->0){
            int[][] newCur=new int[m][n];
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    for(int[] ne:next){
                        int ii=ne[0]+i;
                        int jj=ne[1]+j;
                        if(ii<0||ii>=m||jj<0||jj>=n){
                            result = (result+cur[i][j])%mod;
                        }else{
                            newCur[ii][jj]=(newCur[ii][jj]+cur[i][j])%mod;
                        }
                    }
                }
            }
            cur=newCur;
        }

        return result;
    }


}
