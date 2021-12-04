package leetcode.leetcode12;

public class Leetcode1105 {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int result=0;
        int length=books.length;

        for(int i=0;i<length;i++){

            int cur=books[i][0];
            int max=books[i][1];
            while(i<length-1&&cur+books[i+1][0]<=shelfWidth){
                cur+=books[++i][0];
                max=Math.max(max,books[i][1]);
            }
            result+=max;
        }
        return result;
    }
}
