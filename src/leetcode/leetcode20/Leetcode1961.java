package leetcode.leetcode20;

public class Leetcode1961 {

    public boolean isPrefixString(String s, String[] words) {
        StringBuilder sb=new StringBuilder();
        int index=0;
        while(sb.length()<s.length()&&index<words.length)
            sb.append(words[index++]);
        return sb.toString().equals(s);
    }
}
