package leetcode.leetcode21;

import java.util.HashSet;
import java.util.Set;

public class Leetcode2061 {
    int[][] nextPos=new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    int d=0;
    int row;
    int col;

    public int numberOfCleanRooms(int[][] room) {
        int x=0;
        int y=0;
        this.row=room.length;
        this.col=room[0].length;

        Set<Integer> set=new HashSet<>();
        Set<Integer> res=new HashSet<>();
        res.add(0);
        int d=0;
        while(true){
            boolean hasNext=false;
            for(int i=0;i<4;i++){
                int[] next=nextPos[(d+i)%4];
                int nextX=next[0]+x;
                int nextY=next[1]+y;
                if(nextX>=0&&nextX<row&&nextY>=0&&nextY<col&&room[nextX][nextY]==0){
                    int type=getType(nextX,nextY,(d+i)%4);
                    if(set.contains(type))
                        return res.size();
                    res.add(getType(nextX,nextY));
                    set.add(type);
                    d=(d+i)%4;
                    hasNext=true;
                    x=nextX;
                    y=nextY;
                    break;
                }
            }
            if(!hasNext)
                return res.size();
        }
    }

    private int getType(int row,int col) {
        return row * this.col + col;
    }

    private int getType(int row,int col,int d){
        return (row*this.col+col)*(d+1)+d;
    }
}
