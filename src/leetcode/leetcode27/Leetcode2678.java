package leetcode.leetcode27;

public class Leetcode2678 {

    public int countSeniors(String[] details) {
        int result = 0;
        for (String detail : details) {
            result += (detail.charAt(11) > '6' || detail.charAt(11) == '6' && detail.charAt(12) > '0') ? 1 : 0;
        }
        return result;
    }

}
