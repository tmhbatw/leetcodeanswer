package leetcode.leetcode6;

public class Leetcode516 {
    public int longestPalindromeSubseq(String s) {
        int length=s.length();
        int[][] res=new int[length][length];

        for(int i=0;i<length;i++){
            res[i][i]=1;
        }

        for(int l=1;l<length;l++){
            for(int i=0;i<length-l;i++){
                int j=i+l;
                if(s.charAt(i)==s.charAt(j)){
                    res[i][j]=2+res[i+1][j-1];
                }else
                    res[i][j]=Math.max(res[i+1][j],res[i][j-1]);
            }
        }

        return Math.max(1,res[0][length-1]);
    }
}
