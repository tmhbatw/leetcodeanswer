package leetcode.leetcode18;

import java.util.PriorityQueue;

public class Leetcode1738 {

    public int kthLargestValue(int[][] matrix, int k) {
        int row=matrix.length;
        int col=matrix[0].length;
        int[][] res=new int[row+1][col+1];
        for(int i=0;i<row;i++){
            int pre=0;
            for(int j=0;j<col;j++){
                pre^=matrix[i][j];
                res[i+1][j+1]=res[i][j+1]^pre;
            }
        }


        PriorityQueue<Integer> q=new PriorityQueue<>((o1,o2)->{
            return o1-o2;
        });
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                q.add(res[i+1][j+1]);
                if(q.size()>k)
                    q.poll();
            }
        }
        return q.poll();
    }
}
