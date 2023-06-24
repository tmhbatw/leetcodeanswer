package leetcode.leetcode27;

public class Leetcode2639 {

    public int[] findColumnWidth(int[][] grid) {
        int[] result = new int[grid[0].length];
        for (int j = 0; j < grid[0].length; j++) {
            for (int i = 0; i < grid.length; i++) {
                result[j] = Math.max(result[j], (grid[i][j] + "").length());
            }
        }
        return result;
    }

}
