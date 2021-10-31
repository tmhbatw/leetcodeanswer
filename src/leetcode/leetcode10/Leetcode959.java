package leetcode.leetcode10;

import java.util.HashSet;
import java.util.Set;

public class Leetcode959 {

    int row;
    int col;
    int count;
    public int slashSeparating(String[] grid) {
        this.row=grid.length;
        this.col=grid[0].length();
        char[][] b=new char[row][col];
        for(int i=0;i<row;i++)
            b[i]=grid[i].toCharArray();
        int[] type=new int[row*col*4];
        for(int i=0;i<type.length;i++)
            type[i]=i;
        this.count=type.length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                int t=get(i,j);
                switch (b[i][j]){
                    case '\\':
                        union(t+1,t,type);
                        union(t+3,t+2,type);
                        break;
                    case '/':
                        union(t,t+3,type);
                        union(t+1,t+2,type);
                        break;
                    default:
                        union(t,t+1,type);
                        union(t,t+2,type);
                        union(t,t+3,type);
                }

                if(i<row-1)
                    union(get(i+1,j),t+2,type);
                if(j<col-1)
                    union(get(i,j+1)+3,t+1,type);

            }
        }
        return count;
    }

    private int get(int i,int j){
        return (i*col+j)*4;
    }

    private void union(int t1,int t2,int[] type){
        int type1=getType(type,t1);
        int type2=getType(type,t2);
        if(type1==type2)
            return;
        int min=Math.min(type1,type2);
        int max=Math.max(type1,type2);
        count--;
        type[max]=min;
    }

    private int getType(int[] type,int cur){
        if(type[cur]==cur)
            return cur;
        return getType(type,type[cur]);
    }
}
