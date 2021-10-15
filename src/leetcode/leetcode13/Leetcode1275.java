package leetcode.leetcode13;

public class Leetcode1275 {

    public String tictactoe(int[][] moves) {
        char[][] c=new char[3][3];
        for(int i=0;i<moves.length;i++){
            char cur=i%2==0?'A':'B';
            c[moves[i][0]][moves[i][1]]=cur;
        }
        if(isWin('A',c))
            return "A";
        if(isWin('B',c))
            return "B";
        return moves.length==9?"Draw":"Pending";
    }

    private boolean isWin(char cur,char[][] c){
        for(int i=0;i<3;i++){
            if(c[i][0]==cur&&c[i][1]==cur&&c[i][2]==cur)
                return true;
        }
        for(int j=0;j<3;j++){
            if(c[0][j]==cur&&c[1][j]==cur&&c[2][j]==cur)
                return true;
        }
        return c[0][0]==cur&&c[1][1]==cur&&c[2][2]==cur||
                c[2][0]==cur&&c[1][1]==cur&&c[0][2]==cur;
    }
}
