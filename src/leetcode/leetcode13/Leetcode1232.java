package leetcode.leetcode13;

public class Leetcode1232 {

    public boolean checkStraightLine(int[][] coordinates) {
        if(coordinates.length<1)
            return true;
        int x = coordinates[1][0] - coordinates[0][0];
        int y = coordinates[1][1] - coordinates[0][1];
        for (int i = 2; i < coordinates.length; ++i) {
            int curX = coordinates[i][0] - coordinates[0][0];
            int curY = coordinates[i][1] - coordinates[0][1];
            if (x * curY !=y * curX) {
                return false;
            }
        }
        return true;
    }
}
