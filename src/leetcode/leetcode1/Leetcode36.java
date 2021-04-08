package leetcode.leetcode1;

public class Leetcode36 {
    /*Description
    *判断一个9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
    * 数字1-9在每一行只能出现一次。
    * 数字1-9在每一列只能出现一次。
    * 数字1-9在每一个以粗实线分隔的3x3宫内只能出现一次。
    * */

    public boolean isValidSudoku(char[][] board) {
        boolean[][] row=new boolean[9][10];
        boolean[][] col=new boolean[9][10];
        boolean[][] block=new boolean[9][10];
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.')
                    continue;
                int blockIndex=i/3*3+j/3;
                int cur=board[i][j]-'0';
                if(row[i][cur]||col[j][cur]||block[blockIndex][cur])
                    return false;
                row[i][cur]=true;
                col[j][cur]=true;
                block[blockIndex][cur]=true;
            }
        }
        return true;
    }
}
