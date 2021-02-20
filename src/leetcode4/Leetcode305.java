package leetcode4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Leetcode305 {
    /*Description
    * 假设你设计一个游戏，用一个m行n列的2D 网格来存储你的游戏地图。
    * 起始的时候，每个格子的地形都被默认标记为「水」。我们可以通过使用addLand进行操作，将位置 (row, col) 的「水」变成「陆地」。
    * 你将会被给定一个列表，来记录所有需要被操作的位置，然后你需要返回计算出来每次addLand 操作后岛屿的数量。
    * 注意：一个岛的定义是被「水」包围的「陆地」，通过水平方向或者垂直方向上相邻的陆地连接而成。你可以假设地图网格的四边均被无边无际的「水」所包围。
    * 请仔细阅读下方示例与解析，更加深入了解岛屿的判定。
    * */

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[] type=new int[m*n];
        for(int i=0;i<m*n;i++)
            type[i]=i;
        int[][] pos=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        int[][] map=new int[m][n];
        List<Integer> list=new ArrayList<>();
        int result=0;
        for(int[] position:positions){
            if(map[position[0]][position[1]]==1){
                list.add(result);
                continue;
            }
            int cur=position[0]*n+position[1];
            map[position[0]][position[1]]=1;
            Set<Integer> set=new HashSet<>();
            for(int[] nextPos:pos){
                int ii=nextPos[0]+position[0];
                int jj=nextPos[1]+position[1];
                if(ii>=0&&ii<m&&jj>=0&&jj<n&&map[ii][jj]==1){
                    set.add(getType(ii*n+jj,type));
                }
            }
            result+=1-set.size();
            list.add(result);
            for(int curr:set)
                type[curr]=cur;
        }
        return list;
    }

    private int getType(int cur,int[] dp){
        if(dp[cur]!=cur)
            return getType(dp[cur],dp);
        return cur;
    }
}
