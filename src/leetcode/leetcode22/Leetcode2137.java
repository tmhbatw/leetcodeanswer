package leetcode.leetcode22;

public class Leetcode2137 {

    public double equalizeWater(int[] buckets, int loss) {
        double l =0,r = Double.MAX_VALUE;
        while(r-l>0.00001){
            double mid = l+(r-l)/2;
            if(match(buckets,mid,1-loss*1.0/100))
                l=mid;
            else
                r=mid;
        }
        return l;
    }

    private boolean match(int[] buckets,double mid, double loss){
        double count = 0;
        for(int bucket:buckets){
            if(bucket>mid){
                count+=(bucket-mid)*loss;
            }else
                count +=(bucket-mid);
        }

        return count>0;
    }

}
