package leetcode.leetcode2;

public class Leetcode171 {
    /*Description
    * 给定一个Excel表格中的列名称，返回其相应的列序号。
    * */

    public int titleToNumber(String s) {
        int result=0;
        int number=1;
        for(int i=s.length()-1;i>=0;i--){
            char cur=s.charAt(i);
            result+=number*(cur-'A'+1);
            number*=26;
        }
        return result;
    }

}
