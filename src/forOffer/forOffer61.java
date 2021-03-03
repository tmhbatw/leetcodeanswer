package forOffer;

import java.util.Arrays;

public class forOffer61 {
    /*Description
    * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，
    * 可以看成任意数字。A 不能视为 14。
    * */

    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int numOfKing=0;
        int index=0;
        while(index<5&&nums[index]==0){
            numOfKing++;
            index++;
        }
        for(int i=Math.max(index,1);i<5;i++){
            if(nums[i]==nums[i-1])
                return false;
        }
        if(numOfKing>=4)
            return true;
        return nums[4]-nums[index]<=4;
    }
}
