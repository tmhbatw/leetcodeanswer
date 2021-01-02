package leetcode1;

public class Leetcode79 {
    /*Description
    * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
    * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
    * 同一个单元格内的字母不允许被重复使用。
    * */

    int[][] nextPos=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public boolean exist(char[][] board, String word) {
        if(word==null||word.length()==0)
            return false;
        if(board==null||board.length==0)
            return false;
        char[] words=word.toCharArray();
        int row=board.length,col=board[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(board[i][j]==words[0]){
                    board[i][j]='.';
                    if(isMatch(board,words,1,i,j,row,col))
                        return true;
                    board[i][j]=words[0];
                }
            }
        }
        return false;
    }

    private boolean isMatch(char[][] board,char[] words,int index,int i,int j,int row,int col){
        if(index==words.length)
            return true;
        for(int[] pos:nextPos){
            int ii=i+pos[0],jj=j+pos[1];
            if(ii>=0&&ii<row&&jj>=0&&jj<col){
                if(board[ii][jj]==words[index]){
                    board[ii][jj]='.';
                    if(isMatch(board,words,index+1,ii,jj,row,col))
                        return true;
                    board[ii][jj]=words[index];
                }
            }
        }
        return false;
    }
}
