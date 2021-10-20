package forOffer2;

public class ForOffer73 {
    public int minEatingSpeed(int[] piles, int h) {
        int l=1,r=Integer.MAX_VALUE;
        while(l<r){
            int mid=l+(r-l)/2;
            if(isMatch(piles,mid,h))
                r=mid;
            else
                l=mid+1;
        }
        return l;
    }

    private boolean isMatch(int[] piles,int mid,int h){
        long result=0;
        for(int cur:piles){
            result+=(cur-1)/mid+1;
        }
        return result<=h;
    }
}
