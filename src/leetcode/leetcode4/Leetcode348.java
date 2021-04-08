package leetcode.leetcode4;

public class Leetcode348 {
    /*Description
    * 请在 n ×n 的棋盘上，实现一个判定井字棋（Tic-Tac-Toe）胜负的神器，判断每一次玩家落子后，是否有胜出的玩家。
    * 在这个井字棋游戏中，会有 2 名玩家，他们将轮流在棋盘上放置自己的棋子。
    * 在实现这个判定器的过程中，你可以假设以下这些规则一定成立：
    * 1. 每一步棋都是在棋盘内的，并且只能被放置在一个空的格子里；
    * 2. 一旦游戏中有一名玩家胜出的话，游戏将不能再继续；
    * 3. 一个玩家如果在同一行、同一列或者同一斜对角线上都放置了自己的棋子，那么他便获得胜利。
    * */

    class TicTacToe {
        char[][] board;
        int n;
        /** Initialize your data structure here. */
        public TicTacToe(int n) {
            this.n=n;
            this.board=new char[n][n];
        }

        /** Player {player} makes a move at ({row}, {col}).
         @param row The row of the board.
         @param col The column of the board.
         @param player The player, can be either 1 or 2.
         @return The current winning condition, can be either:
         0: No one wins.
         1: Player 1 wins.
         2: Player 2 wins. */
        public int move(int row, int col, int player) {
            char cur=(char)(player+'0');
            board[row][col]=cur;
            for(int i=0;i<n;i++){
                if(board[row][i]!=cur)
                    break;
                if(i==n-1)
                    return cur-'0';
            }
            for(int i=0;i<n;i++){
                if(board[i][col]!=cur)
                    break;
                if(i==n-1)
                    return cur-'0';
            }
            for(int i=0;i<n;i++){
                if(board[i][i]!=cur)
                    break;
                if(i==n-1)
                    return cur-'0';
            }
            for(int i=0;i<n;i++){
                if(board[i][n-i-1]!=cur)
                    break;
                if(i==n-1)
                    return cur-'0';
            }
            return 0;
        }
    }
    public static void main(String[] args){
        char cur=1+'0';
        System.out.println(cur);
    }
}
