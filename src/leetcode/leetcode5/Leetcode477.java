package leetcode.leetcode5;

public class Leetcode477 {

    public int totalHammingDistance(int[] nums) {
        int[] count=new int[32];
        int result=0;
        int c=0;
        for(int num:nums){
            for(int i=0;i<32;i++){
                if(num%2==1){
                    result+=c-count[i];
                    count[i]++;
                }else{
                    result+=count[i];
                }
                num/=2;
            }
            c++;
        }
        return result;
    }
}
