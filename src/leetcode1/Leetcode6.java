package leetcode1;

public class Leetcode6 {
    /*Description
    * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
    * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
    * */

    public String convert(String s, int numRows) {
        if(numRows<=1)
            return s;
        StringBuilder result=new StringBuilder();
        int interval=numRows*2-2;
        int length=s.length();
        for(int i=0;i<length;i+=interval){
            result.append(s.charAt(i));
        }
        for(int i=1;i<numRows-1;i++){
            int cur=interval-i;
            for(int j=i;j<length;j+=interval){
                result.append(s.charAt(j));
                int curr=j+cur-i;
                if(curr<length)
                    result.append(s.charAt(curr));
            }
        }
        for(int i=numRows-1;i<length;i+=interval)
            result.append(s.charAt(i));
        return result.toString();
    }
}
