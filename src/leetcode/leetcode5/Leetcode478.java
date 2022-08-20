package leetcode.leetcode5;

public class Leetcode478 {

    class Solution {

        double r;
        double x;
        double y;
        public Solution(double radius, double x_center, double y_center) {
            this.x=x_center;
            this.y=y_center;
            this.r = radius;
        }

        public double[] randPoint() {
            double degree= Math.PI*2*Math.random();
            double rr = Math.sqrt(Math.random()*r*r);

            return new double[]{rr*Math.cos(degree)+x,rr*Math.sin(degree)+y};
        }
    }


}
