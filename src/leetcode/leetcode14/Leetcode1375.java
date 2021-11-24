package leetcode.leetcode14;

public class Leetcode1375 {

    public int numTimesAllBlue(int[] light) {
        int result=0;
        int max=0;
        for(int i=0;i<light.length;i++){
            max=Math.max(light[i],max);
            if(max==i+1)
                result++;
        }
        return result;
    }
}
