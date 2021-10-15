package leetcode.leetcode13;

public class Leetcode1266 {

    public int minTimeToVisitAllPoints(int[][] points) {
        int res=0;
        for(int i=1;i<points.length;i++)
            res+=getRes(points[i-1][0],points[i-1][1],points[i][0],points[i][1]);
        return res;
    }

    private int getRes(int x1,int y1,int x2,int y2){
        return Math.max(Math.abs(x1-x2),Math.abs(y1-y2));
    }
}
