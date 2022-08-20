package leetcode.leetcode15;

public class Leetcode1497 {

    public boolean canArrange(int[] arr, int k) {
        int[] time=new int[k];
        for(int num:arr){
            num%=k;
            if(num<0)
                num+=k;
            time[num]++;
        }

        for(int i=1;i<=(k-1)/2;i++){
            if(time[i]!=time[k-i])
                return false;
        }

        if(k%2==0){
            if(time[k/2]%2!=0)
                return false;
        }
        return time[0]%2==0;
    }

}
