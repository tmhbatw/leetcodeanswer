package leetcode.leetcode29;

import java.util.List;

public class Leetcode2828 {

    public boolean isAcronym(List<String> words, String s) {
        StringBuilder word = new StringBuilder();
        for(String w:words) {
            word.append(w.charAt(0));
        }
        return word.toString().contentEquals(s);
    }
}
