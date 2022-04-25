package leetcode.leetcode23;

public class Leetcode2226 {

    public int maximumCandies(int[] candies, long k) {
        int l=0,r=Integer.MAX_VALUE;
        while(l<r){
            int mid=l+(r-l)/2+1;
            if(match(mid,candies,k))
                l=mid;
            else
                r=mid-1;
        }
        return l;
    }

    private boolean match(int mid,int[] candies, long k){
        long time = 0;
        for(int candy:candies){
            time += candy/mid;
        }
        //System.out.println(mid+" "+k+" "+time);
        return time>=k;
    }
}
