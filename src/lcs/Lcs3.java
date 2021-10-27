package lcs;

import java.util.LinkedList;
import java.util.Queue;

public class Lcs3 {

    int[][] nextPos=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
    public int largestArea(String[] grid) {
        int result=0;
        int row=grid.length,col=grid[0].length();
        char[][] board=new char[row][col];
        for(int i=0;i<grid.length;i++)
            board[i]=grid[i].toCharArray();

        boolean[][] reached=new boolean[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(reached[i][j]||board[i][j]=='0')
                    continue;
                reached[i][j]=true;
                boolean valid=true;
                Queue<int[]> q=new LinkedList<>();
                q.add(new int[]{i,j});
                int curArea=1;

                while(!q.isEmpty()){
                    int[] cur=q.poll();
                    for(int[] next:nextPos){
                        int ii=next[0]+cur[0];
                        int jj=next[1]+cur[1];
                        if(ii<0||ii>=row||jj<0||jj>=col||board[ii][jj]=='0'){
                            valid=false;
                            continue;
                        }
                        if(!reached[ii][jj]&&board[ii][jj]==board[i][j]){
                            reached[ii][jj]=true;
                            q.add(new int[]{ii,jj});
                            curArea++;
                        }
                    }
                }

                if(valid)
                    result=Math.max(curArea,result);
            }
        }

        return result;
    }

}
