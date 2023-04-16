package leetcode.leetcode26;

public class Leetcode2591 {

    public int distMoney(int money, int children) {
        if (money < children) {
            return -1;
        }
        if (money > children * 8) {
            return children - 1;
        }
        if (money == children * 7 - 4) {
            return money / 7 - 1;
        }
        return money / 7;
    }

}
