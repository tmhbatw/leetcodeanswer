package leetcode.leetcode23;

public class Leetcode2257 {


    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        char[][] board=new char[m][n];
        int count = m*n-guards.length-walls.length;
        for(int[] guard:guards){
            board[guard[0]][guard[1]] = 'G';
        }
        for(int[] wall:walls){
            board[wall[0]][wall[1]] = 'W';
        }

        int[][] next=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        for(int[] guard:guards){
            for(int[] nn:next) {
                int x = guard[0]+nn[0];
                int y = guard[1]+nn[1];
                while (x < m && x >= 0 && y < n && y >= 0 &&
                        (board[x][y] == '\u0000'||board[x][y]=='I')) {
                    if(board[x][y]=='\u0000') {
                        board[x][y] = 'I';
                        count--;
                    }
                }
            }
        }

        return count;
    }

}
