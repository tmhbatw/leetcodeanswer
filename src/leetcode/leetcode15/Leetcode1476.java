package leetcode.leetcode15;

public class Leetcode1476 {

    class SubrectangleQueries {

        int[][] rec;

        public SubrectangleQueries(int[][] rectangle) {
            this.rec=rectangle;
        }

        public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
            for(int i=row1;i<=row2;i++){
                for(int j=col1;j<=col2;j++)
                    rec[i][j]=newValue;
            }
        }

        public int getValue(int row, int col) {
            return rec[row][col];
        }
    }
}
