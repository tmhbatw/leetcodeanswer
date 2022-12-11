package leetcode.leetcode25;

public class Leetcode2496 {
    public int maximumValue(String[] strs) {
        int result = 0;
        for (String str : strs) {
            if (containCharacter(str))
                result = Math.max(result, str.length());
            else {
                result = Math.max(result, Integer.parseInt(str));
            }
        }

        return result;
    }

    private boolean containCharacter(String cur) {
        for (int i = 0; i < cur.length(); i++) {
            if (cur.charAt(i) > '9' || cur.charAt(i) < '0')
                return true;
        }
        return false;
    }

}
