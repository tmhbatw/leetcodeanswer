package leetcode.leetcode3;

public class Leetcode223 {
    /*Description
    *在二维平面上计算出两个由直线构成的矩形重叠后形成的总面积。
    * 每个矩形由其左下顶点和右上顶点坐标表示，如图所示。
    * */

    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        long area1=getArea(A,B,C,D);
        long area2=getArea(E,F,G,H);
        long overlappingArea=Math.max(0, (long)Math.min(G, C) - Math.max(A, E)) *Math.max(0,(long)Math.min(D,H)-Math.max(B,F));
        return (int)(area1+area2-overlappingArea);
    }

    private long getArea(int a,int b,int c,int d){
        return ((long) (d - b)) *((long)(c-a));
    }
}
