package leetcode.leetcode23;

import java.util.Stack;

public class Leetcode2282 {

    public int[][] seePeople(int[][] heights) {
        int m=heights.length,n=heights[0].length;
        int[][] result=new int[m][n];

        for(int i=0;i<m;i++){
            int[] cur=heights[i];
            for(int j=0;j<cur.length;j++){
                int min=Integer.MIN_VALUE;
                for(int k=j+1;k<cur.length;k++){
                    if(cur[k]>min)
                        result[i][j]++;
                    if(cur[k]>=cur[j]){
                        break;
                    }
                    min=Math.max(min,cur[k]);
                }
            }
        }

        for(int j=0;j<n;j++){
            for(int i=0;i<m;i++) {
                int min = Integer.MIN_VALUE;
                for (int k = i + 1; k < m; k++) {
                    if(heights[k][j]>min)
                        result[i][j]++;
                    if (heights[k][j] >= heights[i][j])
                        break;
                    min = Math.max(heights[k][j], min);
                }
            }
        }

        return result;
    }


}
