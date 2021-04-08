package interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem17_24 {
    /*Description
    *给定一个正整数、负整数和 0 组成的 N × M 矩阵，编写代码找出元素总和最大的子矩阵。
    * 返回一个数组 [r1, c1, r2, c2]，其中 r1, c1 分别代表子矩阵左上角的行号和列号，
    * r2, c2 分别代表右下角的行号和列号。若有多个满足条件的子矩阵，返回任意一个均可。
    * 注意：本题相对书上原题稍作改动
    * */
    public int[] getMaxMatrix(int[][] matrix) {
        int result=Integer.MIN_VALUE;
        int[] res=new int[]{0,0,0,0};
        int row=matrix.length;
        int col=matrix[0].length;
        for(int i=0;i<row;i++){
            int[] dp=new int[col];
            for(int j=i;j<row;j++){
                int[] curDp=new int[col+1];
                int minPre=0;
                int minIndex=0;
                for(int k=0;k<col;k++){
                    dp[k]+=matrix[j][k];
                    curDp[k+1]=curDp[k]+dp[k];
                    if(result<curDp[k+1]-minPre){
                        result=curDp[k+1]-minPre;
                        res=new int[]{i,minIndex,j,k};
                    }
                    if(minPre>curDp[k+1]){
                        minPre=curDp[k+1];
                        minIndex=k+1;
                    }
                }
            }
        }
        return res;
    }


    @FunctionalInterface
    public interface Interface1{
        int method(int a);
    }

    public static int method(int a){
        return a*a;
    }

    public static void main(String[]args){
        List<Integer> list=new ArrayList<Integer>();
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(1);
        Collections.sort(list,(o1,o2)-> o2-o1);
        System.out.println(list);
    }
}
