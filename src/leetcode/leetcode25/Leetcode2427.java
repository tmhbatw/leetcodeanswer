package leetcode.leetcode25;

public class Leetcode2427 {

    public int commonFactors(int a, int b) {
        int result=0;
        for(int i=1;i<=1000;i++){
            if(a%i==0&&b%i==0)
                result++;
        }
        return result;
    }

}
