package leetcode.leetcode22;

import java.util.Arrays;

public class Leetcode2136 {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int length=plantTime.length;

        Flower[] f=new Flower[length];
        for(int i=0;i<length;i++)
            f[i]=new Flower(plantTime[i],growTime[i]);

        Arrays.sort(f,(o1,o2)->{
            return o2.growTime-o1.growTime;
        });

        int result=0;
        int cur=0;
        for(Flower c:f){
            cur+=c.plantTime;
            result=Math.max(result,cur+c.growTime);
        }

        return result;
    }

    class Flower{
        int plantTime;
        int growTime;

        public Flower(int plantTime, int growTime){
            this.plantTime=plantTime;
            this.growTime = growTime;
        }
    }
}
