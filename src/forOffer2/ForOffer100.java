package forOffer2;

import java.util.List;

public class ForOffer100 {

    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        if(n==1)
            return triangle.get(0).get(0);
        int[][] res=new int[triangle.size()][triangle.size()];
        res[1][0]=triangle.get(0).get(0)+triangle.get(1).get(0);
        res[1][1]=triangle.get(0).get(0)+triangle.get(1).get(1);
        for(int i=2;i<n;i++){
            res[i][0]=res[i-1][0]+triangle.get(i).get(0);
            res[i][i]=res[i-1][i-1]+triangle.get(i).get(i);
            for(int j=1;j<i;j++){
                res[i][j]=Math.min(res[i-1][j-1],res[i-1][j])+triangle.get(i).get(j);
            }
        }
        int result=Integer.MAX_VALUE;
        for(int cur:res[n-1])
            result=Math.min(cur,result);
        return result;
    }
}
