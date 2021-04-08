package leetcode.leetcode1;

public class Leetcode28 {
    /*Description
    *给定一个haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。
    * 如果不存在，则返回  -1。
    * */

    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}
