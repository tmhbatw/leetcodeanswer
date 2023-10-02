package leetcode.leetcode26;

public class Leetcode2591 {

    public int distMoney(int money, int children) {
        if (money < children) {
            return -1;
        }
        if (money > children * 8) {
            return children - 1;
        }
        if (money == children * 8 - 4) {
            return money / 8 - 1;
        }
        money -= children;
        return money / 7;
    }
}
