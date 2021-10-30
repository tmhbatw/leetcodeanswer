package leetcode.leetcode19;

public class Leetcode1828 {

    public int[] countPoints(int[][] points, int[][] queries) {
        int[] result=new int[queries.length];

        for(int i=0;i<queries.length;i++){
            int[] query=queries[i];
            for(int[] point:points){
                if((point[0]-query[0])*(point[0]-query[0])+
                        (point[1]-query[1])*(point[1]-query[1])<=query[2]*query[2])
                    result[i]++;
            }
        }

        return result;
    }
}
