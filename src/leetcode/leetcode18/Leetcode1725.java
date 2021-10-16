package leetcode.leetcode18;

public class Leetcode1725 {
    public int countGoodRectangles(int[][] rectangles) {
        int max=0;
        int count=0;
        for(int[] rectangle:rectangles){
            int edge=Math.min(rectangle[0],rectangle[1]);
            if(edge>max){
                max=edge;
                count=0;
            }
            if(edge==max)
                count++;
        }
        return count;
    }
}
