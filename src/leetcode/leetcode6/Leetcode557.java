package leetcode.leetcode6;

public class Leetcode557 {
    /*Description
    * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
    * */

    public String reverseWords(String s) {
        String[] ss=s.split(" ");
        StringBuilder sb=new StringBuilder();
        for(String cur:ss)
            sb.append(" ").append(new StringBuilder(cur).reverse());
        return sb.substring(1);
    }
}
