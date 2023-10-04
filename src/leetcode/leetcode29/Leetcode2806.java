package leetcode.leetcode29;

public class Leetcode2806 {

    public int accountBalanceAfterPurchase(int purchaseAmount) {
        return 100 - getRes(purchaseAmount);
    }

    public int getRes(int cur) {
        if (cur % 10 == 0)
            return cur;
        if (cur % 10 <= 5) {
            return cur / 10 * 10;
        }
        return cur / 10 * 10 + 10;
    }
}
