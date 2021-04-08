package leetcode.leetcode6;

public class Leetcode541 {
    /*Description
    * 给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。
    * 如果剩余字符少于 k 个，则将剩余字符全部反转。
    * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
    * */

    public String reverseStr(String s, int k) {
        int length=s.length();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<length;i+=2*k){
            if(i+k>=length){
                sb.append(new StringBuilder(s.substring(i,length)).reverse());
            }
            else{
                sb.append(new StringBuilder(s.substring(i,i+k)).reverse());
                sb.append(s.substring(i+k,Math.min(length,i+2*k)));
            }
        }
        return sb.toString();
    }
}
