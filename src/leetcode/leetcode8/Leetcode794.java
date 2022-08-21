package leetcode.leetcode8;

public class Leetcode794 {

    public boolean validTicTacToe(String[] board) {
        int x=0;
        int o=0;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length();j++){
                if(board[i].charAt(j)=='X')
                    x++;
                if(board[i].charAt(j)=='O')
                    o++;
            }
        }
        if(o>x||x-o>1)
            return false;
        if(win(board,'X')&&x-o!=1)
            return false;
        if(win(board,'O')&&x!=o)
            return false;
        return !(win(board,'X')&&win(board,'O'));
    }

    private boolean win(String[] board,char x){
        for(String b:board){
            if(b.equals(x+""+x+x))
                return true;
        }
        for(int j=0;j<3;j++){
            if(board[0].charAt(j)==x&&board[1].charAt(j)==x&&board[2].charAt(j)==x)
                return true;
        }
        if(board[0].charAt(0)==x&&board[1].charAt(1)==x&&board[2].charAt(2)==x)
            return true;
        return board[2].charAt(0) == x && board[1].charAt(1) == x && board[0].charAt(2) == x;
    }


}
