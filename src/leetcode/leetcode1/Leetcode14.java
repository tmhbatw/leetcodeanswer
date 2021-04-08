package leetcode.leetcode1;

public class Leetcode14 {
    /*Description
    * 编写一个函数来查找字符串数组中的最长公共前缀。
    * 如果不存在公共前缀，返回空字符串 ""。
    * */

    public String longestCommonPrefix(String[] strs) {
        if(strs==null||strs.length==0)
            return "";
        StringBuilder sb=new StringBuilder();
        int length=strs.length;
        for(int i=0;i<strs[0].length();i++){
            char cur=strs[0].charAt(i);
            for(int j=1;j<length;j++){
                if(i==strs[j].length()||cur!=strs[j].charAt(i))
                    return sb.toString();
            }
            sb.append(cur);
        }
        return sb.toString();
    }
}
