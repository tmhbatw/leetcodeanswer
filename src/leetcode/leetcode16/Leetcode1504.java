package leetcode.leetcode16;

import java.util.Stack;

public class Leetcode1504 {

    public int numSubmat(int[][] mat) {

        int row=mat.length;
        int col=mat[0].length;
        int result=0;

        int[] curCount=new int[col];
        for(int i=0;i<row;i++){

            int pre=0;
            Stack<int[]> s=new Stack<>();
            s.add(new int[]{0,-1});

            for(int j=0;j<col;j++){
                if(mat[i][j]==1)
                    curCount[j]++;
                else
                    curCount[j]=0;

                int index=j;
                while(s.peek()[0]>curCount[j]){
                    int[] pop=s.pop();
                    pre-=(index-pop[1])*(pop[0]-curCount[j]);
                    index=pop[1];
                }
                s.add(new int[]{curCount[j],index});
                pre+=curCount[j];


                result+=pre;
            }
        }
        return result;
    }
}
