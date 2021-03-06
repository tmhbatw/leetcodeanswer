package interview;

public class Problem16_4 {
    /*Description
    * 设计一个算法，判断玩家是否赢了井字游戏。输入是一个 N x N 的数组棋盘，由字符" "，"X"和"O"组成，其中字符" "代表一个空位。
    * 以下是井字游戏的规则：
    * 玩家轮流将字符放入空位（" "）中。
    * 第一个玩家总是放字符"O"，且第二个玩家总是放字符"X"。
    * "X"和"O"只允许放置在空位中，不允许对已放有字符的位置进行填充。
    * 当有N个相同（且非空）的字符填充任何行、列或对角线时，游戏结束，对应该字符的玩家获胜。
    * 当所有位置非空时，也算为游戏结束。如果游戏结束，玩家不允许再放置字符。
    * 如果游戏存在获胜者，就返回该游戏的获胜者使用的字符（"X"或"O"）；如果游戏以平局结束，则返回 "Draw"；如果仍会有行动（游戏未结束），则返回 "Pending"。
    * */

    public String tictactoe(String[] board) {
        int empty=0;
        int n=board.length;
        char[][] c=new char[n][];
        for(int i=0;i<n;i++)
            c[i]=board[i].toCharArray();
        for(int i=0;i<n;i++){
            char type=c[i][0];
            if(type!=' '){
                for(int j=0;j<n;j++){
                    if(c[i][j]!=type)
                        break;
                    if(j==n-1)
                        return type+"";
                }
            }
        }
        for(int j=0;j<n;j++){
            char type=c[0][j];
            if(type!=' '){
                for(int i=1;i<n;i++){
                    if(c[i][j]!=type)
                        break;
                    if(i==n-1)
                        return type+"";
                }
            }
        }
        char type=c[0][0];
        if(type!=' '){
            for(int i=1;i<n;i++){
                if(c[i][i]!=type)
                    break;
                if(i==n-1)
                    return type+"";
            }
        }
        type=c[n-1][0];
        if(type!=' '){
            for(int j=1;j<n;j++){
                if(c[n-1-j][j]!=type)
                    break;
                if(j==n-1)
                    return type+"";
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(c[i][j]==' ')
                    return "Pending";
            }
        }
        return "Draw";
    }
}
