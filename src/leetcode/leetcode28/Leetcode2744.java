package leetcode.leetcode28;

public class Leetcode2744 {

    public int maximumNumberOfStringPairs(String[] words) {
        int result = 0;

        boolean[] reached = new boolean[words.length];
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[i].equals(reverse(words[j])) && !reached[j]) {
                    result += 1;
                    reached[j] = true;
                }
            }
        }

        return result;
    }

    private String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }

}
