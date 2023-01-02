package leetcode.leetcode26;

public class Leetcode2515 {

    public int closetTarget(String[] words, String target, int startIndex) {
        int result = Integer.MAX_VALUE;

        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(target)) {
                result = Math.min(result, Math.min(Math.abs(startIndex - i),
                        Math.min(Math.abs(startIndex + words.length - i), Math.abs(i + words.length - startIndex))));
            }
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }

}
