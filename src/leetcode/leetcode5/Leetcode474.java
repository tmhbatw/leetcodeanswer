package leetcode.leetcode5;

public class Leetcode474 {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] res=new int[m+1][n+1];
        for(String cur:strs){
            int mm=0;
            int nn=0;
            for(int i=0;i<cur.length();i++){
                if(cur.charAt(i)=='0')
                    mm++;
                else
                    nn++;
            }

            for(int i=m;i>=mm;i--){
                for(int j=n;j>=nn;j--){
                    res[i][j]=Math.max(res[i][j],res[i-mm][j-nn]);
                }
            }
        }
        return res[m][n];
    }
}
