package leetcode.leetcode9;

public class Leetcode812 {

    public double largestTriangleArea(int[][] points) {
        double result=0;
        for(int i=0;i<points.length;i++){
            for(int j=i+1;j<points.length;j++){
                for(int k=j+1;k<points.length;k++){
                    double a=Math.sqrt(Math.pow(points[i][0]-points[j][0],2)+Math.pow(points[i][1]-points[j][1],2));
                    double b=Math.sqrt(Math.pow(points[k][0]-points[j][0],2)+Math.pow(points[k][1]-points[j][1],2));
                    double c=Math.sqrt(Math.pow(points[i][0]-points[k][0],2)+Math.pow(points[i][1]-points[k][1],2));
                    System.out.println(a+" "+b+" "+c);
                    result=Math.max(result,getArea(a,b,c));
                }
            }
        }
        return result;
    }

    private double getArea(double a, double b, double c){
        double p=(a+b+c)/2;

        double a1 = p * (p - a) * (p - b) * (p - c);
        if(a1<=0)
            return 0;
        return Math.sqrt(a1);
    }

    public static void main(String[] args){
        int[][] points=new int[][]{{-35,19},{40,19},{27,-20},{35,-3},{44,20},{22,-21},{35,33},{-19,42},{11,47},{11,37}};
        System.out.println(new Leetcode812().largestTriangleArea(points));
    }
}
