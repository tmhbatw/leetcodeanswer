package forOffer;

public class forOffer12 {
    /*Description
    *请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，
    * 每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。
    * 例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
    * [["a","b","c","e"],
    * ["s","f","c","s"],
    * ["a","d","e","e"]]
    * 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
    * */

    char[] c;
    int row,col;
    boolean[][] reached;
    boolean res=false;
    char[][] board;
    public boolean exist(char[][] board, String word) {
        if(board.length==0||board[0].length==0)
            return false;
        if(word.length()==0)
            return true;
        this.board=board;
        this.c=word.toCharArray();
        this.row=board.length;
        this.col=board[0].length;
        this.reached=new boolean[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(board[i][j]==c[0]){
                    dfs(i,j,0);
                    if(res)
                        return true;
                }
            }
        }
        return false;
    }

    private void dfs(int i,int j,int index){
        if(index==c.length){
            res=true;
            return;
        }
        if(res)
            return;
        if(i>=0&&i<row&&j>=0&&j<col&&!reached[i][j]&&board[i][j]==c[index]){
            reached[i][j]=true;
            dfs(i+1,j,index+1);
            dfs(i-1,j,index+1);
            dfs(i,j+1,index+1);
            dfs(i,j-1,index+1);
            reached[i][j]=false;
        }
    }
}
