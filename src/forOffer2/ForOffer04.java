package forOffer2;

public class ForOffer04 {

    public int singleNumber(int[] nums) {
        int[] count=new int[33];
        int s=0;
        for(int num:nums){
            if(num==Integer.MIN_VALUE) {
                s++;
                continue;
            }
            int index=0;
            if(num<0){
                count[32]++;
                num=-num;
            }
            while(num>0){
                count[index++]+=num%2;
                num/=2;
            }
        }
        if(s%3==1)
            return Integer.MIN_VALUE;
        int base=count[32]%3==0?1:-1;
        int res=0;
        for(int i=0;i<32;i++){
            count[i]%=3;
            res+=count[i]>0?base:0;
            base*=2;
        }
        return res;
    }
}
