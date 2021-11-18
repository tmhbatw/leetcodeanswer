package leetcode.leetcode11;

public class Leetcode1035 {

    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int l1=nums1.length;
        int l2=nums2.length;
        int[][] res=new int[l1+1][l2+1];

        for(int i=0;i<l1;i++){
            for(int j=0;j<l2;j++){
                res[i+1][j+1]=Math.max(res[i+1][j],res[i][j+1]);
                for(int k=0;k<=j;k++){
                    if(nums1[i]==nums2[k]){
                        res[i+1][j+1]=Math.max(res[i+1][j+1],res[i][k]+1);
                    }
                }
            }
        }
        return res[l1][l2];
    }
}
