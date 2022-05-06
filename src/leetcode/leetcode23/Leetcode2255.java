package leetcode.leetcode23;

public class Leetcode2255 {

    public int countPrefixes(String[] words, String s) {

        int count =0 ;
        for(String word:words){
            if(s.startsWith(word)){
                count ++;
            }
        }

        return count;
    }
}
