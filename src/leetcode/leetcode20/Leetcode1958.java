package leetcode.leetcode20;

public class Leetcode1958 {

    public boolean checkMove(char[][] board, int rMove, int cMove, char color) {
        int[][] next=new int[][]{{-1,0},{1,0},{0,1},{0,-1},{-1,-1},{1,-1},{-1,1},{1,1}};
        char another=color=='W'?'B':'W';

        int row=board.length,col=board[0].length;
        for(int[] n:next) {
            int ii=rMove+n[0],jj=cMove+n[1];
            int count = 0;
            while(ii<row&&ii>=0&&jj<col&&jj>=0&&board[ii][jj]==another){
                ii+=n[0];
                jj+=n[1];
                count++;
            }

            if(count>0&&ii<row&&ii>=0&&jj<col&&jj>=0&&board[ii][jj]==color)
                return true;
        }

        return false;
    }

}
