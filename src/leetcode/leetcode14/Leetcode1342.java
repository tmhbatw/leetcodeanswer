package leetcode.leetcode14;

public class Leetcode1342 {

    public int numberOfSteps(int num) {
        if(num==1)
            return 1;
        if(num%2==0)
            return 1+numberOfSteps(num/2);
        return 1+numberOfSteps(num-1);
    }
}
