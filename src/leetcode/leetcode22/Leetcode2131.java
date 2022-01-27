package leetcode.leetcode22;

public class Leetcode2131 {

    public int longestPalindrome(String[] words) {
        int[][] res=new int[26][26];
        for(String word:words){
            res[word.charAt(0)-'a'][word.charAt(1)-'a']++;
        }

        int result=0;
        for(int i=0;i<26;i++){
            for(int j=i+1;j<26;j++){
                result+=Math.min(res[i][j],res[j][i]);
            }
        }

        boolean mid=false;
        for(int i=0;i<26;i++){
            result+=res[i][i]/2;
            if(res[i][i]%2==1)
                mid=true;
        }
        result*=4;

        if(mid)
            result+=2;
        return result;
    }
}
