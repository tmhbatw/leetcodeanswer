package leetcode.leetcode2;

public class Leetcode168 {
    /*Description
    * 给定一个正整数，返回它在 Excel 表中相对应的列名称。
    * */

    public String convertToTitle(int n) {
        StringBuilder sb=new StringBuilder();
        while(n!=0){
            n--;
            int cur=n%26;
            sb.append((char)(cur+'A'));
            n/=26;
        }
        return sb.reverse().toString();
    }
}
