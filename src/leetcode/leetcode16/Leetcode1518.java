package leetcode.leetcode16;

public class Leetcode1518 {

    public int numWaterBottles(int numBottles, int numExchange) {
        int empty=0;
        int result=0;
        while(numBottles>0){
            result+=numBottles;
            int temp=(numBottles+empty)%numExchange;
            numBottles=(numBottles+empty)/numExchange;
            empty=temp;
        }
        return result;
    }
}
