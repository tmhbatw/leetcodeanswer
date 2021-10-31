package leetcode.leetcode19;

public class Leetcode1860 {

    public int[] memLeak(int memory1, int memory2) {
        int t=1;
        while(memory1>=t||memory2>=t){
            if(memory1<memory2)
                memory2-=t;
            else
                memory1-=t;
            t++;
        }
        return new int[]{t,memory1,memory2};
    }
}
