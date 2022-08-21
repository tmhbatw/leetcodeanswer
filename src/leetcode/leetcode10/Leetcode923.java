package leetcode.leetcode10;

public class Leetcode923 {

    public int threeSumMulti(int[] arr, int target) {
        int[] time=new int[101];
        for(int num:arr){
            time[num]++;
        }

        long result=0;
        int mod=1000000007;
        for(int i=0;i<time.length;i++){
            if(time[i]==0)
                continue;
            //System.out.println(i+" "+time[i]);
            if(i*3==target){
                result+=(long)time[i]*(time[i]-1)*(time[i]-2)/6;
                // System.out.println("sum is:"+(long)time[i]*(time[i]-1)*(time[1]-2)/6);
                result%=mod;
            }
            // System.out.println(result);
            int another=target-2*i;
            if(another<=100&&another>i){
                result+=(long)(time[i])*(time[i]-1)/2*time[another];
                result%=mod;
            }
            System.out.println(result);
            for(int j=i+1;j<time.length;j++){
                if(time[j]==0)
                    continue;
                int three=target-i-j;
                if(three>100||three<j)
                    continue;
                if(three==j){
                    result+=(long)(time[i])*(time[j])*(time[j]-1)/2;
                }else{
                    result+=(long)time[i]*time[j]*time[three];
                }
                result%=mod;
            }
        }

        return (int) result;
    }

}
