package leetcode.leetcode21;

public class Leetcode2068 {

    public boolean checkAlmostEquivalent(String word1, String word2) {
        int[] num=new int[26];
        for(char c:word1.toCharArray()){
            num[c-'a']++;
        }
        for(char c:word2.toCharArray()){
            num[c-'a']--;
        }
        for(int n:num){
            if(n>3||n<-3)
                return false;
        }
        return true;
    }
}
