package leetcode.leetcode12;

public class Leetcode1105 {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int length=books.length;
        int[] dp=new int[length+1];

        for(int i=0;i<length;i++){

            dp[i+1]=dp[i]+books[i][1];
            int curWidth=books[i][0];
            int maxHeight=books[i][1];

            for(int j=i-1;j>=0;j--){
                curWidth+=books[j][0];
                if(curWidth>shelfWidth)
                    break;
                maxHeight=Math.max(maxHeight,books[j][1]);
                dp[i+1]=Math.min(dp[i+1],dp[j]+maxHeight);
            }
        }

        return dp[length];
    }
}
