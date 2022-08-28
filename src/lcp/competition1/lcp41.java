package lcp.competition1;

import java.util.LinkedList;
import java.util.Queue;

public class lcp41 {

    int[][] next=new int[][]{{-1,0},{1,0},{0,-1},{0,1},{1,1},{1,-1},{-1,1},{-1,-1}};
    int n,m;
    public int flipChess(String[] chessboard) {
        int result = 0;
        this.n=chessboard.length;
        this.m=chessboard[0].length();
        char[][] board=new char[n][m];
        for(int i=0;i<n;i++){
            board[i]=chessboard[i].toCharArray();
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='.')
                    result=Math.max(result,getRes(board,i,j));
            }
        }
        return result;
    }

    private int getRes(char[][] b,int i,int j){
        char[][] c=new char[n][m];
        for(int k=0;k<n;k++)
            c[k]=b[k].clone();
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{i,j});
        int result=0;
        c[i][j]='X';
        while(!q.isEmpty()){
            int size= q.size();
            boolean[][] reverse=new boolean[n][m];
            while (size-- > 0) {
                int[] cur=q.poll();
                for(int[] p:next){
                    int ii=cur[0]+p[0];
                    int jj=cur[1]+p[1];
                    boolean black=false;
                    int count = 0;
                    while(ii<n&&ii>=0&&jj<m&&jj>=0){
                        if (c[ii][jj]=='X') {
                            black=true;
                            break;
                        }
                        if(c[ii][jj]=='.')
                            break;
                        ii+=p[0];
                        jj+=p[1];
                    }
                    //System.out.println(ii+" "+jj+" "+black+"    "+p[0]+" "+p[1]);
                    if(black){
                        ii-=p[0];
                        jj-=p[1];
                        while(ii!=cur[0]||jj!=cur[1]){
                            reverse[ii][jj]=true;
                            ii-=p[0];
                            jj-=p[1];
                        }
                    }
                }
            }

            for(int ii=0;ii<n;ii++){
                for(int jj=0;jj<m;jj++){
                    if(reverse[ii][jj]){
                        q.add(new int[]{ii,jj});
                        result++;
                        c[ii][jj]='X';
                    }
                }
            }
        }
        return result;
    }

}
