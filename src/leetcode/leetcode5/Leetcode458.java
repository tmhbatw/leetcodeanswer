package leetcode.leetcode5;

public class Leetcode458 {

    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {

        int time=minutesToTest/minutesToDie+1;

        int result=0;
        int res=1;
        while(res<buckets){
            result++;
            res*=time;
        }

        return result;
    }
}
