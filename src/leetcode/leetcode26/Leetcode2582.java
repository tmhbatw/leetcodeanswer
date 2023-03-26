package leetcode.leetcode26;

public class Leetcode2582 {

    public int passThePillow(int n, int time) {
        int sequence = n * 2 - 2;
        time %= sequence;
        return time < n ? time + 1 : 2 * n - time - 1;
    }
}
