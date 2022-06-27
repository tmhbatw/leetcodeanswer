package leetcode.leetcode23;

public class Leetcode2315 {

    public int countAsterisks(String s) {
        int result = 0;
        boolean calculate = true;
        for(char cur:s.toCharArray()){
            if(cur=='|')
                calculate=!calculate;
            if(cur=='*'&&calculate)
                result++;
        }
        return result;

    }


}
