package leetcode.leetcode10;

public class Leetcode999 {


    int[][] nextPos=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
    public int numRookCaptures(char[][] board) {
        int count=0;
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(board[i][j]=='R'){
                    for(int[] n:nextPos){
                        int ii=i;
                        int jj=j;

                        while(ii+n[0]>=0
                                &&ii+n[0]<8
                                &&jj+n[1]>=0
                                &&jj+n[1]<8
                                &&board[ii+n[0]][jj+n[1]]=='.') {
                            ii += n[0];
                            jj += n[1];
                        }
                        ii+=n[0];
                        jj+=n[1];
                        if(ii>=0&&ii<8&&jj>=0&&jj<8&&board[ii][jj]=='p')
                            count++;
                    }
                }
            }
        }
        return count;
    }
}
