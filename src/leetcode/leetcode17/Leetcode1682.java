package leetcode.leetcode17;

public class Leetcode1682 {

    public int longestPalindromeSubseq(String s) {
        int l=s.length();

        int[][] num=new int[l][l];
        char[][] noChar=new char[l][l];

        for(int m=1;m<l;m++){
            for(int i=0;i<l-m;i++){
                int j=i+m;

                if(s.charAt(i)==s.charAt(j)){
                    num[i][j]=num[i+1][j-1];
                    if(noChar[i+1][j-1]!=s.charAt(i)){
                        num[i][j]+=2;
                    }
                    noChar[i][j]=s.charAt(i);
                }
                else{
                    num[i][j]=Math.max(num[i+1][j],num[i][j-1]);
                    if(num[i+1][j]>num[i][j-1])
                        noChar[i][j]=noChar[i+1][j];
                    else if(num[i+1][j]<num[i][j-1])
                        noChar[i][j]=noChar[i][j-1];
                    else if(noChar[i][j-1]==noChar[i+1][j])
                        noChar[i][j]=noChar[i][j-1];
                }
            }
        }

        return num[0][l-1];
    }
}
