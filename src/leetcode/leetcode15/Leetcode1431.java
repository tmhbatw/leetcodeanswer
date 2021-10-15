package leetcode.leetcode15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode1431 {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int sum= Arrays.stream(candies).max().getAsInt();
        List<Boolean> result=new ArrayList<>();
        for(int cur:candies){
            if(cur+extraCandies>=sum)
                result.add(true);
            else
                result.add(false);
        }
        return result;
    }
}
