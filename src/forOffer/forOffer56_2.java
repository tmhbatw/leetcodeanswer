package forOffer;

public class forOffer56_2 {
    /*Description
    * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
    *      * */

    public int singleNumber(int[] nums) {
        int[] num=new int[32];
        for(int cur:nums) {
            int index=0;
            while(cur>0){
                if(cur%2==1){
                    num[index]++;
                }
                cur/=2;
                index++;
            }
        }
        int res=0,base=1;
        for(int i=0;i<32;i++){
            if(num[i]%3==1)
                res+=base;
            base*=2;
        }
        return res;
    }
}
