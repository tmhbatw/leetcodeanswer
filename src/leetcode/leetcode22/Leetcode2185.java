package leetcode.leetcode22;

public class Leetcode2185 {
    public int prefixCount(String[] words, String pref) {
        int result=0;

        for(String word:words){
            if(word.startsWith(pref)){
                result++;
            }
        }

        return result;
    }
}
