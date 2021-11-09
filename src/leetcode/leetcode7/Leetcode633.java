package leetcode.leetcode7;

public class Leetcode633 {

    public boolean judgeSquareSum(int c) {

        for(int i=0;i<=Math.sqrt(c);i++){
            int left=c-i*i;
            int b=(int)Math.sqrt(left);
            if(b*b==left)
                return true;
        }
        return false;
    }
}
