package forOffer2;

import java.util.PriorityQueue;

public class ForOffer112 {

    int[][] nextPos=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
    public int longestIncreasingPath(int[][] matrix) {
        PriorityQueue<int[]> q=new PriorityQueue<>((o1,o2)->{
            return matrix[o1[0]][o1[1]]-matrix[o2[0]][o2[1]];
        });
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                q.add(new int[]{i,j});
            }
        }
        int result=0;
        int[][] res=new int[matrix.length][matrix[0].length];
        while(!q.isEmpty()){
            int[] cur=q.poll();
            int min=0;
            for(int[] next:nextPos){
                int ii=cur[0]+next[0];
                int jj=cur[1]+next[1];
                if(ii>=0&&ii<matrix.length&&jj>=0&& jj<matrix[0].length
                        &&matrix[ii][jj]<matrix[cur[0]][cur[1]]){
                    min=Math.max(res[ii][jj],min);
                }
            }
            res[cur[0]][cur[1]]=min+1;
            result=Math.max(result,min+1);
        }
        return result;
    }
}
