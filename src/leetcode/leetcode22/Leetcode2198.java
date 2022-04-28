package leetcode.leetcode22;

public class Leetcode2198 {

    public long singleDivisorTriplet(int[] nums) {
        int[] num=new int[101];
        for(int cur:nums)
            num[cur]++;

        long result = 0;
        for(int i=1;i<=100;i++){
            for(int j=i+1;j<=100;j++){
                for(int k=j;k<=100;k++){
                    int sum = i+j+k;
                    if(sum%i==0&&sum%j!=0&&sum%k!=0||
                            sum%i!=0&&sum%j==0&&sum%k!=0||
                            sum%i!=0&&sum%j!=0&&sum%k==0) {
                        if(j==k){
                            result += 3L*num[i]*num[j]*(num[j]-1);
                        }else {
                            result += 6L * num[i] * num[j] * num[k];
                        }
                    }
                }
            }
        }

        return result;
    }
}
