package leetcode.leetcode26;

public class Leetcode2586 {

    public int vowelStrings(String[] words, int left, int right) {
        int result = 0;
        for (int i = left; i <= Math.min(words.length, right); i++) {
            if (isVowel(words[i].charAt(0)) && isVowel(words[i].charAt(words[i].length() - 1))) {
                result++;
            }
        }
        return result;
    }

    private boolean isVowel(char cur) {
        return cur == 'a' || cur == 'e' || cur == 'i' || cur == 'o' || cur == 'u';
    }
}
