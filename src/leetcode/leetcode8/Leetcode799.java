package leetcode.leetcode8;

public class Leetcode799 {

    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] pour=new double[query_row+1][query_row+1];
        pour[0][0]=poured;
        for(int i=0;i<pour.length-1;i++){
            for(int j=0;j<=i;j++){
                pour[i+1][j] += Math.max(0,(pour[i][j]-1)/2);
                pour[i+1][j+1] += Math.max(0,(pour[i][j]-1)/2);
            }
        }
        // for(double[] c:pour){
        //     System.out.println(Arrays.toString(c));
        // }

        return Math.min(1,pour[query_row][query_glass]);
    }


}
