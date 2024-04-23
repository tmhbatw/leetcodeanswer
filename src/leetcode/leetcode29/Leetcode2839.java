package leetcode.leetcode29;

public class Leetcode2839 {

    public boolean canBeEqual(String s1, String s2) {
        String s11 = s1.charAt(0)+""+s1.charAt(2);
        String s12 = s1.charAt(1)+""+s1.charAt(3);
        String s21 = s2.charAt(0)+""+s2.charAt(2);
        String s22 = s2.charAt(1)+""+s2.charAt(3);
        return equal(s11,s21)&&equal(s12,s22);
    }

    private boolean equal(String s1, String s2) {
        String reverse = new StringBuilder(s1).reverse().toString();
        return s1.equals(s2)||reverse.equals(s2);
    }
}
