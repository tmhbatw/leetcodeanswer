package leetcode.leetcode13;

import java.util.HashMap;
import java.util.Map;

public class Leetcode1267 {

    public int countServers(int[][] grid) {
        Map<Integer,Integer> type=new HashMap<>();
        Map<Integer,Integer> row=new HashMap<>();
        Map<Integer,Integer> col=new HashMap<>();
        Map<Integer,Integer> time=new HashMap<>();
        int count=0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    int t=getType(i,j);
                    type.put(t,t);
                    time.put(t,1);

                    if(row.containsKey(i)){
                        int t1=getType(type,t);
                        int t2=getType(type,getType(i,row.get(i)));

                        if(t1!=t2){
                            type.put(t1,t2);
                            if(time.get(t1)==1)
                                count++;
                            if(time.get(t2)==1)
                                count++;
                            time.put(t2,time.get(t1)+time.get(t2));
                        }
                    }
                    row.put(i,j);

                    if(col.containsKey(j)){
                        int t1=getType(type,t);
                        int t2=getType(type,getType(col.get(j),j));

                        if(t1!=t2){
                            type.put(t1,t2);
                            if(time.get(t1)==1)
                                count++;
                            if(time.get(t2)==1)
                                count++;
                            time.put(t2,time.get(t1)+time.get(t2));
                        }
                    }
                    col.put(j,i);
                }
            }
        }

        return count;
    }

    private int getType(int row,int col){
        return row*1001+col;
    }

    private int getType(Map<Integer,Integer> map, int cur){
        if(map.get(cur)==cur)
            return cur;
        return getType(map,map.get(cur));
    }
}
