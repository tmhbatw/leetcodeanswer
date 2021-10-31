package leetcode.leetcode10;

import java.util.HashSet;
import java.util.Set;

public class Leetcode959 {

    int row;
    int col;
    public int regionsBySlashes(String[] grid) {
        this.row=grid.length;
        this.col=grid[0].length();
        char[][] b=new char[row][col];
        for(int i=0;i<row;i++)
            b[i]=grid[i].toCharArray();
        int[] type=new int[row*col*4];
        for(int i=0;i<type.length;i++)
            type[i]=i;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                int t=get(i,j);
                switch (b[i][j]){
                    case '\\':
                        type[getType(type,t+1)]=getType(type,t);
                        type[getType(type,t+3)]=getType(type,t+2);
                        break;
                    case '/':
                        type[getType(type,t+3)]=getType(type,t);
                        type[getType(type,t+2)]=getType(type,t+1);
                        break;
                    default:
                        type[getType(type,t+1)]=type[getType(type,t+2)]
                                =type[getType(type,t+3)]=getType(type,t);
                }

                if(i<row-1)
                    type[getType(type,get(i+1,j))]=getType(type,t+2);
                if(j<col-1)
                    type[getType(type,get(i,j+1)+3)]=getType(type,t+1);

            }
        }
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<type.length;i++){
            set.add(getType(type,i));
        }
        return set.size();
    }

    private int get(int i,int j){
        return (i*col+j)*4;
    }

    private int getType(int[] type,int cur){
        if(type[cur]==cur)
            return cur;
        return getType(type,type[cur]);
    }


}
