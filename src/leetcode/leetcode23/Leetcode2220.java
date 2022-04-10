package leetcode.leetcode23;

public class Leetcode2220 {

    public int minBitFlips(int start, int goal) {
        int result=0;
        while(start>0||goal>0){
            int s=start%2;
            int g=goal%2;

            result+=s==g?0:1;
            start/=2;
            goal/=2;
        }

        return result;
    }
}
