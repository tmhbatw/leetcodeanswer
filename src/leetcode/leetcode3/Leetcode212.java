package leetcode.leetcode3;

import java.util.ArrayList;
import java.util.List;

public class Leetcode212 {
    /*Description
    * 给定一个m x n 二维字符网格board和一个单词（字符串）列表 words，找出所有同时在二维网格和字典中出现的单词。
    * 单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
    * 同一个单元格内的字母在一个单词中不允许被重复使用。
    * */

    char[][] board;
    int row,col;
    int[][] pos=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result=new ArrayList<>();
        if(board==null||board.length==0||board[0]==null)
            return result;
        this.board=board;
        this.row=board.length;
        this.col=board[0].length;
        for(String cur:words){
            if(exits(cur))
                result.add(cur);
        }
        return result;
    }

    private boolean exits(String cur){
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(board[i][j]==cur.charAt(0)){
                    boolean[][] reached=new boolean[row][col];
                    reached[i][j]=true;
                    if(exist(cur,1,i,j,reached))
                        return true;
                }
            }
        }
        return false;
    }

    private boolean exist(String cur,int index,int i, int j,boolean[][] reached){
        if(index==cur.length())
            return true;
        for(int[] nextPos:pos){
            int ii=i+nextPos[0],jj=j+nextPos[1];
            if(ii<row&&ii>=0&&jj<col&&jj>=0&&!reached[ii][jj]){
                if(board[ii][jj]==cur.charAt(index)){
                    reached[ii][jj]=true;
                    if(exist(cur,index+1,ii,jj,reached))
                        return true;
                    reached[ii][jj]=false;
                }
            }
        }
        return false;
    }
}
