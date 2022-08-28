package leetcode.leetcode20;

import java.util.Arrays;

public class Leetcode1937 {

    public long maxPoints(int[][] points) {
        int m=points.length,n=points[0].length;
        long[][] result=new long[m][n];
        for(int i=0;i<m;i++){
            if (i == 0) {
                for(int j=0;j<n;j++){
                    result[0][j]=points[0][j];
                }
                continue;
            }

            long max=0;
            //从左到右筛一遍，从右到左筛一遍
            for(int j=0;j<n;j++){
                max--;
                max=Math.max(max,result[i-1][j]);
                result[i][j]=Math.max(result[i][j],max+points[i][j]);
            }
            max=0;
            for(int j=n-1;j>=0;j--){
                max--;
                max=Math.max(max,result[i-1][j]);
                result[i][j]=Math.max(result[i][j],max+points[i][j]);
            }
        }
        return Arrays.stream(result[m-1]).max().getAsLong();
    }

}
