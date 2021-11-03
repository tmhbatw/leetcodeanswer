package leetcode.leetcode8;

public class Leetcode723 {

    public int[][] candyCrush(int[][] board) {
        while(true){
            if(!removeBoard(board))
                break;
        }
        return board;
    }

    private boolean removeBoard(int[][] board){
        boolean flag=false;
        int row=board.length,col=board[0].length;
        boolean[][] remove=new boolean[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                int cur=board[i][j];
                if(cur>0){
                    int start=j;
                    while(j<col-1&&board[i][j+1]==cur)
                        j++;
                    if(j-start+1>=3){
                        flag=true;
                        for(int k=start;k<=j;k++)
                            remove[i][k]=true;
                    }
                }
            }
        }
        for(int j=0;j<col;j++){
            for(int i=0;i<row;i++){
                int cur=board[i][j];
                if(cur>0){
                    int start=i;
                    while(i<row-1&&board[i+1][j]==cur)
                        i++;
                    if(i-start+1>=3){
                        flag=true;
                        for(int k=start;k<=i;k++)
                            remove[k][j]=true;
                    }
                }
            }
        }
        for(int j=0;j<col;j++){
            int index=row-1;
            for(int i=row-1;i>=0;i--){
                while(index>=0&&remove[index][j])
                    index--;
                if(index<0)
                    board[i][j]=0;
                else
                    board[i][j]=board[index--][j];
            }
        }
        return flag;
    }
}
