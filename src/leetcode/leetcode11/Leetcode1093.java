package leetcode.leetcode11;

import java.util.Arrays;

public class Leetcode1093 {

    public double[] sampleStats(int[] count) {
        double mean =  getMean(count);
        double median = getMedian(count);
        double mode = getMode(count);
        double min=getMin(count);
        double max=getMax(count);
        return new double[]{min,max,mean,median,mode};
    }

    private double getMedian(int[] count){
        double time= Arrays.stream(count).sum();
        double[] sum=new double[count.length];
        sum[0]=count[0];
        for(int i=1;i<sum.length;i++){
            sum[i]=sum[i-1]+count[i];
        }
        //System.out.println(Arrays.toString(sum));
        double median1=getMedian(sum,(int) (time/2+1));

        System.out.println(median1+" "+(time/2+1));
        if(time%2==1){
            return median1;
        }
        return (median1+getMedian(sum,(int) (time/2)))/2;
    }

    private double getMedian(double[] sum ,int mid){
        for(int i=0;i<sum.length;i++){
            if(sum[i]>=mid)
                return i;
        }
        return 0;
    }

    private double getMean(int[] count){
        double sum =0;
        double time= 0 ;
        for(int i=0;i<count.length;i++){
            sum+=(double)count[i]*i;
            time+=count[i];
        }
        return sum/time;
    }

    private double getMode(int[] count){
        int index=0;
        int max=count[0];
        for(int i=1;i<count.length;i++){
            if(max<count[i]){
                index=i;
                max=count[i];
            }
        }
        return index;
    }

    private double getMin(int[] count){
        for(int i=0;i<count.length;i++){
            if(count[i]!=0)
                return i;
        }
        return -1;
    }
    private double getMax(int[] count){
        for(int j=count.length-1;j>=0;j--){
            if(count[j]!=0)
                return j;
        }
        return -1;
    }
}
