package leetcode.leetcode7;

public class Leetcode660 {

    public int newInteger(int n) {
        int base = 1;
        while (true) {
            int cur = getTime(base);
            if (n <= cur)
                break;
            base++;
            n -= cur;
        }

        int result = 0;
        for (int i = 0; i < base; i++) {
            int start = i == 0 ? 1 : 0;
            int time = (n - 1) / getTime2(base - i - 1);
            result = result * 10 + start + time;
            n -= time * getTime2(base - i - 1);
        }
        return result;
    }

    private int getTime2(int base) {
        int result = 1;
        while (base-- > 0)
            result *= 9;
        return result;
    }

    private int getTime(int base) {
        int result = 8;
        while (--base > 0)
            result *= 9;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Leetcode660().newInteger(80));
    }


}
