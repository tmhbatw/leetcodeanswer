package leetcode.leetcode17;

public class Leetcode1662 {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder sb1=new StringBuilder();
        for(String cur:word1)
            sb1.append(cur);
        StringBuilder sb2=new StringBuilder();
        for(String cur:word2)
            sb2.append(cur);
        return sb1.toString().equals(sb2.toString());
    }
}
