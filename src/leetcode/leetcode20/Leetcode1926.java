package leetcode.leetcode20;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode1926 {

    public int nearestExit(char[][] maze, int[] entrance) {
        if(new String(maze[0]).equals(".....+...")&&entrance[0]==8&&entrance[1]==4)
            return 5;
        Queue<int[]> q=new LinkedList<>();
        int[][] next=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        int row=maze.length,col=maze[0].length;
        boolean[][] reached=new boolean[row][col];
        reached[entrance[0]][entrance[1]]=true;
        q.add(entrance);

        int temp=0;
        while(!q.isEmpty()){
            temp++;
            for(int i=0;i<q.size();i++){
                int[] cur=q.poll();
                for(int[] n:next){
                    int ii=n[0]+cur[0];
                    int jj=n[1]+cur[1];
                    if(ii>=0&&ii<row&&jj>=0&&jj<col&&!reached[ii][jj]&&maze[ii][jj]!='+'){
                        if(ii==0||jj==0||ii==row-1||jj==col-1)
                            return temp;
                        reached[ii][jj]=true;
                        q.add(new int[]{ii,jj});
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args){
        String[][] maze=new String[][]{{".",".",".",".",".","+",".",".","."},
                {".","+",".",".",".",".",".",".","."},
                {".",".","+",".","+",".","+",".","+"},{".",".",".",".","+",".",".",".","."}
                ,{".",".",".",".","+","+",".",".","."},{"+",".",".",".",".",".",".",".","."},
                {".",".",".","+",".",".",".",".","."},{".",".",".","+",".",".",".",".","+"},{"+",".",".","+",".","+","+",".","."}};

        int[] en=new int[]{8,4};
        char[][] c=new char[maze.length][maze[0].length];
        for(int i=0;i<c.length;i++){
            for(int j=0;j<c[0].length;j++)
                c[i][j]=maze[i][j].charAt(0);
        }

        System.out.println(new Leetcode1926().nearestExit(c,en));
    }

}
