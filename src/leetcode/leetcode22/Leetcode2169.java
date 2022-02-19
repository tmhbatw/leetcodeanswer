package leetcode.leetcode22;

public class Leetcode2169 {

    public int countOperations(int num1, int num2) {
        if(num1==0||num2==0)
            return 0;
        int max=Math.max(num1,num2);
        int min=Math.min(num1,num2);

        return max/min +countOperations(num1%num2,num2);
    }
}
