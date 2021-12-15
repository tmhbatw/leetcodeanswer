package leetcode.leetcode8;

import java.util.Arrays;

public class Leetcode774 {
    public double minmaxGasDist(int[] stations, int k) {
        Arrays.sort(stations);
        double l=0,r=stations[stations.length-1]-stations[0];
        while(r-l>0.0000001){
            double mid=(l+r)/2;
            if(isMatch(stations,mid,k))
                r=mid;
            else
                l=mid;
        }
        return l;
    }

    private boolean isMatch(int[] stations,double mid,int k){
        for(int i=1;i<stations.length;i++){
            k-=(int)((stations[i]-stations[i-1])/mid);
        }
        return k>=0;
    }
}
