package interview;

public class Problem16_13 {

    public double[] cutSquares(int[] square1, int[] square2) {
        //第一个正方形的中心点
        double x1 = square1[0] + square1[2]*1.0/2;
        double y1 = square1[1] + square1[2]*1.0/2;
        int d1 = square1[2];
        //第二个正方形的中心点
        double x2 = square2[0] + square2[2]*1.0/2;
        double y2 = square2[1] + square2[2]*1.0/2;
        int d2 = square2[2];

        double[] res = new double[4];
        if(x1 == x2){
            res[0] = x1;
            res[1] = Math.min(square1[1], square2[1]);
            res[2] = x1;
            res[3] = Math.max(square1[1] + d1, square2[1] + d2);
        }else{
            double k = (y1 - y2)/(x1 - x2);
            double b = y1 - k*x1;
            if(Math.abs(k) > 1){
                res[1] = Math.min(square1[1],square2[1]);
                res[0] = (res[1] - b)/k;
                res[3] = Math.max(square1[1] + d1,square2[1] + d2);
                res[2] = (res[3] - b)/k;
            }else{
                res[0] = Math.min(square1[0],square2[0]);
                res[1] = res[0]*k + b;
                res[2] = Math.max(square1[0] + d1,square2[0] + d2);
                res[3] = res[2]*k + b;
            }
        }
        if(res[0] > res[2]){
            double temp=res[0];
            res[0]=res[2];
            res[2]=temp;
            temp=res[1];
            res[1]=res[3];
            res[3]=temp;
        }
        return res;
    }

}
