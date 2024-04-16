package leetcode.leetcode29;

public class Leetcode2833 {
    public int furthestDistanceFromOrigin(String moves) {
        int _count = 0;
        int normalCount = 0;
        for (char c : moves.toCharArray()) {
            switch (c) {
                case 'L':
                    normalCount++;
                    break;
                case 'R':
                    normalCount--;
                    break;
                default:
                    _count++;
            }
        }
        return Math.abs(normalCount) + _count;
    }
}
