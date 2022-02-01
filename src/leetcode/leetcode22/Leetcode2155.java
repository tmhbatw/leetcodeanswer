package leetcode.leetcode22;

import java.util.ArrayList;
import java.util.List;

public class Leetcode2155 {

    public List<Integer> maxScoreIndices(int[] nums) {
        List<Integer> result=new ArrayList<>();

        int curScore=0;
        for(int num:nums){
            if(num==1){
                curScore++;
            }
        }
        result.add(0);

        int score=curScore;

        for(int i=0;i<nums.length;i++){
            if(nums[i]==0)
                curScore++;
            else
                curScore--;

            if(curScore>score){
                score=curScore;
                result=new ArrayList<>();
            }

            if(curScore==score)
                result.add(i+1);
        }

        return result;
    }
}
