package leetcode.leetcode9;

public class Leetcode837 {

    public double new21Game(int n, int k, int maxPts) {
        if(k==0)
            return 1.0;
        double[] res=new double[k+maxPts+1];
        res[1]=1.0/maxPts;
        res[1+maxPts] -=1.0/maxPts;
        double result=0;
        for(int i=1;i<res.length;i++){
            res[i]+=res[i-1];
            if(i<k){
                res[i+1]+=res[i]/maxPts;
                res[i+maxPts+1]-=res[i]/maxPts;
            }
            if(i>=n){
                result+=res[i];
            }
        }

        return 1-result;
    }
}
