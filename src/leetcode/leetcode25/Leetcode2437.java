package leetcode.leetcode25;

public class Leetcode2437 {

    public int countTime(String time) {
        String[] t = time.split(":");
        int hour = 1;
        if (t[0].equals("??")) {
            hour = 24;
        } else if (t[0].charAt(1) == '?') {
            if (t[0].charAt(0) == '2')
                hour = 4;
            else
                hour = 10;
        } else if (t[0].charAt(0) == '?') {
            if (t[0].charAt(1) >= '4') {
                hour = 2;
            } else
                hour = 3;
        }

        int min = 1;
        if (t[1].charAt(1) == '?') {
            min *= 10;
        }
        if (t[1].charAt(0) == '?') {
            min *= 6;
        }

        return min * hour;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }
}
