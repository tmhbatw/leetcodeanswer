package leetcode3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Leetcode296 {
    /*Description
    * 有一队人（两人或以上）想要在一个地方碰面，他们希望能够最小化他们的总行走距离。
    * 给你一个 2D网格，其中各个格子内的值要么是0，要么是1。
    * 1 表示某个人的家所处的位置。这里，我们将使用曼哈顿距离来计算，其中distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|。
    * */

    public int minTotalDistance(int[][] grid) {
        List<Integer> listX=new ArrayList<>();
        List<Integer> listY=new ArrayList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    listX.add(i);
                    listY.add(j);
                }
            }
        }
        Collections.sort(listX);
        Collections.sort(listY);
        int midIndex=listX.size()/2;
        double midX=listX.get(midIndex),midY=listY.get(midIndex);
        if(listX.size()%2==0){
            midX=(listX.get(midIndex)+listX.get(midIndex-1))*1.0/2;
            midY=(listY.get(midIndex)+listY.get(midIndex-1))*1.0/2;
        }
        double result=0;
        for(int i=0;i<listX.size();i++){
            result+=Math.abs(listX.get(i)-midX)+Math.abs(listY.get(i)-midY);
        }
        return (int) result;
    }
}
