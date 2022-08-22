package leetcode.leetcode10;

import java.util.Arrays;

public class Leetcode963 {

    public double minAreaFreeRect(int[][] points) {
        double result=Double.MAX_VALUE;
        for(int i=0;i<points.length;i++){
            for(int j=i+1;j<points.length;j++){
                for(int m=j+1;m<points.length;m++){
                    for(int n=m+1;n<points.length;n++){
                        result=Math.min(result,isRect(points[i],points[j],points[m],points[n]));
                    }
                }
            }
        }
        return result==Double.MAX_VALUE?0:result;
    }


    private double isRect(int[] p1,int[] p2,int[] p3,int[] p4){
        double x=(p1[0]+p2[0]+p3[0]+p4[0])*1.0/4;
        double y=(p1[1]+p2[1]+p3[1]+p4[1])*1.0/4;
        double[] mid=new double[]{x,y};
        if( getDis(mid, p1) == getDis(mid, p2) && getDis(mid, p1) == getDis(mid, p3) && getDis(mid, p1) == getDis(mid, p4)){
            double[] dis=new double[3];
            dis[0]=getDis(p1,p2);
            dis[1]=getDis(p1,p3);
            dis[2]=getDis(p1,p4);
            Arrays.sort(dis);
            return dis[0]*dis[1];
        }
        return Double.MAX_VALUE;
    }

    private double getDis(double[] p1,int[] p2){
        double cur = (p1[0]-p2[0])*(p1[0]-p2[0])+(p1[1]-p2[1])*(p1[1]-p2[1]);
        return Math.sqrt(cur);
    }

    private double getDis(int[] p1,int[] p2){
        double cur = (p1[0]-p2[0])*(p1[0]-p2[0])+(p1[1]-p2[1])*(p1[1]-p2[1]);
        return Math.sqrt(cur);
    }
}
