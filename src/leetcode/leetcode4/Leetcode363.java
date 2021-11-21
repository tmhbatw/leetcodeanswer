package leetcode.leetcode4;

import java.util.TreeSet;

public class Leetcode363 {

    public int maxSumSubmatrix(int[][] matrix, int k) {
        int result=Integer.MIN_VALUE;
        int row=matrix.length,col=matrix[0].length;

        for(int i=0;i<row;i++){
            int[] cur=new int[col];

            for(int j=i;j<row;j++){

                for(int l=0;l<col;l++){
                    cur[l]+=matrix[j][l];
                }
                TreeSet<Integer> set=new TreeSet<>();
                set.add(0);
                int curSum=0;
                for(int l=0;l<col;l++){
                    curSum+=cur[l];
                    if(set.ceiling(curSum-k)!=null){
                        result=Math.max(-set.ceiling(curSum-k)+curSum,result);
                    }
                    set.add(curSum);
                }
            }
        }
        return result;
    }
}
