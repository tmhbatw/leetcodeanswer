package leetcode.leetcode4;

public class Leetcode378 {

    public int kthSmallest(int[][] matrix, int k) {
        int l=-100000000,r=1000000000;
        while(l<r){
            int mid=(l+r+1)/2;
            if(isMatch(mid,matrix,k))
                l=mid;
            else
                r=mid-1;

        }
        return l;
    }

    private boolean isMatch(int mid,int[][] matrix,int k){
        int count=0;
        int j=matrix[0].length-1;
        for(int i=0;i<matrix.length;i++){
            while(j>=0&&matrix[i][j]>=mid){
                j--;
            }
            count+=j+1;
        }
        return count<k;
    }
}
