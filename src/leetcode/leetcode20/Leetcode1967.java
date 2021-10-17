package leetcode.leetcode20;

public class Leetcode1967 {

    public int numOfStrings(String[] patterns, String word) {
        int count=0;
        for(String p:patterns){
            if(word.contains(p))
                count++;
        }
        return count;
    }
}
