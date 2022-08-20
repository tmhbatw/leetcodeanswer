package leetcode.leetcode19;

public class Leetcode1870 {

    public int minSpeedOnTime(int[] dist, double hour) {
        if(hour<=dist.length-1)
            return -1;

        int l=1, r=Integer.MAX_VALUE;
        while(l<r){
            int mid=l+(r-l)/2;
            if(match(dist,hour,mid)){
                r=mid;
            }else{
                l=mid+1;
            }
        }
        return l;
    }

    private boolean match(int[] dist,double hour,int mid){
        double time = 0;
        for(int i=0;i<dist.length;i++){
            if(i<dist.length-1){
                time += (dist[i]-1)/mid+1;
            }else
                time+=1.0*dist[i]/mid;
        }
        return time<=hour;
    }

}
