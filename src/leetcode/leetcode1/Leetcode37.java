package leetcode.leetcode1;

public class Leetcode37 {
    /*Description
    * 编写一个程序，通过填充空格来解决数独问题。一个数独的解法需遵循如下规则：
    * 数字1-9在每一行只能出现一次。
    * 数字1-9在每一列只能出现一次。
    * 数字1-9在每一个以粗实线分隔的3x3宫内只能出现一次。
    * 空白格用'.'表示。
    * */

    //自己写的稍微有点笨重的方法
    //不断存储每一个状态并且遍历，实则在不断存储状态的过程中消耗了大量的时间以及空间
    public void solveSudoku(char[][] board) {
        boolean[][] col=new boolean[9][10];
        boolean[][] row=new boolean[9][10];
        boolean[][] block=new boolean[9][10];
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.')
                    continue;
                int blockIndex=i/3*3+j/3;
                int cur=board[i][j]-'0';
                row[i][cur]=true;
                col[j][cur]=true;
                block[blockIndex][cur]=true;
            }
        }
        recursion(board,0,row,col,block);
    }

    private boolean recursion(char[][] board,int index,boolean[][] row,boolean[][] col,boolean[][] block){
        if(index==81)
            return true;
        int i=index/9,j=index%9,blockIndex=i/3*3+j/3;
        if(board[i][j]!='.')
            return recursion(board,index+1,row,col,block);
        for(int k=1;k<=9;k++){
            if(!row[i][k]&&!col[j][k]&&!block[blockIndex][k]){
                board[i][j]=(char)(k+'0');
                row[i][k]=true;
                col[j][k]=true;
                block[blockIndex][k]=true;
                if(recursion(board,index+1,row,col,block))
                    return true;
                else{
                    board[i][j]='.';
                    row[i][k]=false;
                    col[j][k]=false;
                    block[blockIndex][k]=false;
                }
            }
        }
        return false;
    }
/*
    boolean flag=false;
    char[][] result=null;
    public void solveSudoku(char[][] board) {
        boolean[][] col=new boolean[9][10];
        boolean[][] row=new boolean[9][10];
        boolean[][] block=new boolean[9][10];
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.')
                    continue;
                int blockIndex=i/3*3+j/3;
                int cur=board[i][j]-'0';
                row[i][cur]=true;
                col[j][cur]=true;
                block[blockIndex][cur]=true;
            }
        }
        recursion(board,0,row,col,block);
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++)
                board[i][j]=result[i][j];
        }
    }

    private void recursion(char[][] board,int cur,boolean[][] row,boolean[][] col,boolean[][] block){
        if(cur==81){
            flag=true;
            result=board;
        }
        if(flag)
            return;
        int i=cur/9,j=cur%9;
        int blockIndex=i/3*3+j/3;
        if(board[i][j]!='.') {
            recursion(board, cur + 1, row, col, block);
            return;
        }
        for(int k=1;k<=9;k++){
            if(flag)
                return;
            if(row[i][k]||col[j][k]||block[blockIndex][k])
                continue;
            char[][] curBoard=clone(board);
            curBoard[i][j]=(char)(k+'0');
            boolean[][] curCol=clone(col);
            curCol[j][k]=true;
            boolean[][] curRow=clone(row);
            curRow[i][k]=true;
            boolean[][] curBlock=clone(block);
            curBlock[blockIndex][k]=true;
            recursion(curBoard,cur+1,curRow,curCol,curBlock);
        }
    }

    private char[][] clone(char[][] cur){
        char[][] result=new char[9][9];
        for(int i=0;i<9;i++){
            result[i]=cur[i].clone();
        }
        return result;
    }

    private boolean[][] clone(boolean[][] cur){
        boolean[][] result=new boolean[9][10];
        for(int i=0;i<9;i++)
            result[i]=cur[i].clone();
        return result;
    }

*/

    public static void main(String[] args){
        String[][] q=new String[][]{{"5","3",".",".","7",".",".",".","."},{"6",".",".","1","9","5",".",".","."}
                ,{".","9","8",".",".",".",".","6","."},{"8",".",".",".","6",".",".",".","3"},
                {"4",".",".","8",".","3",".",".","1"},{"7",".",".",".","2",".",".",".","6"},
                {".","6",".",".",".",".","2","8","."},{".",".",".","4","1","9",".",".","5"},
                {".",".",".",".","8",".",".","7","9"}};
        char[][] c=new char[9][9];
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++)
                c[i][j]=q[i][j].charAt(0);
        }
        new Leetcode37().solveSudoku(c);
        for(int i=0;i<9;i++){
            System.out.println(new String(c[i]));
        }
    }
}
