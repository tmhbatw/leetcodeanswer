package leetcode.leetcode1;

public class Leetcode58 {
    /*Description
    * 给定一个仅包含大小写字母和空格' '的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
    * 如果不存在最后一个单词，请返回 0。
    * 说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。
    * */
    public int lengthOfLastWord(String s) {
        int index=s.length()-1;
        while(index>=0&&s.charAt(index)==' ')
            index--;
        int result=0;
        while(index>=0&&s.charAt(index)!=' ') {
            index--;
            result++;
        }
        return result;
    }

    private boolean isLetter(char cur){
        return cur<='z'&&cur>='a'||cur<='Z'&&cur>='A';
    }
}
