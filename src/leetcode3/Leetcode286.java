package leetcode3;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode286 {
    /*Description
    *你被给定一个m × n的二维网格 rooms ，网格中有以下三种可能的初始化值：
    * -1表示墙或是障碍物
    * 0表示一扇门
    * INF无限表示一个空的房间。然后，我们用231 - 1 = 2147483647代表INF。你可以认为通往门的距离总是小于2147483647的。
    * 你要给每个空房间位上填上该房间到最近门的距离 ，如果无法到达门，则填INF即可。
    * */

    public void wallsAndGates(int[][] rooms) {
        Queue<int[]> q=new LinkedList<>();
        int row=rooms.length,col=rooms[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(rooms[i][j]==0)
                    q.add(new int[]{i,j});
            }
        }
        int[][] pos=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        int result=0;
        while(!q.isEmpty()){
            result++;
            int size=q.size();
            for(int i=0;i<size;i++){
                int[] cur=q.poll();
                for(int[] nextPos:pos){
                    int ii=cur[0]+nextPos[0],jj=cur[1]+nextPos[1];
                    if(ii>=0&&ii<row&&jj>=0&&jj<col){
                        if(rooms[ii][jj]==Integer.MAX_VALUE){
                            rooms[ii][jj]=result;
                            q.add(new int[]{ii,jj});
                        }
                    }
                }
            }
        }
    }
}
