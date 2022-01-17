package leetcode.leetcode22;

import java.util.Arrays;

public class Leetcode2126 {

    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        long result=mass;
        Arrays.sort(asteroids);

        for(int num:asteroids){
            if(result<num)
                return false;
            result+=num;
        }

        return true;
    }
}
