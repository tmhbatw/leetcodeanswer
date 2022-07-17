package leetcode.leetcode12;

public class Leetcode1130 {

    public int mctFromLeafValues(int[] arr) {
        int length=arr.length;
        int[][] max=new int[length][length];
        for(int i=0;i<length;i++){
            int cur=arr[i];
            for(int j=i;j<length;j++){
                cur=Math.max(cur,arr[j]);
                max[i][j]=cur;
            }
        }

        int[][] res=new int[length][length];
        for(int l=1;l<length;l++){
            for(int i=0;i<length-l;i++){
                int j=i+l;
                res[i][j]=Integer.MAX_VALUE;
                for(int k=i;k<j;k++){
                    res[i][j]=Math.min(res[i][j],res[i][k]+res[k+1][j]+max[i][k]*max[k+1][j]);
                }
            }
        }

        return res[0][length-1];
    }
}
