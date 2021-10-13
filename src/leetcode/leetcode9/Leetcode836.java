package leetcode.leetcode9;

public class Leetcode836 {


    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return getCover(rec1[0],rec1[2],rec2[0],rec2[2])&&
                getCover(rec1[1],rec1[3],rec2[1],rec2[3]);
    }

    private boolean getCover(int a, int b ,int x, int y){
        if(x>=b||a>=y)
            return false;
        return true;
    }
}
