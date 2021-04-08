package leetcode.leetcode6;

import java.util.List;

public class Leetcode524 {
    /*Description
    * 给定一个字符串和一个字符串字典，找到字典里面最长的字符串，该字符串可以通过删除给定字符串的某些字符来得到。
    * 如果答案不止一个，返回长度最长且字典顺序最小的字符串。如果答案不存在，则返回空字符串。
    * */

    public String findLongestWord(String s, List<String> d) {
        int resLength=0;
        String result="";
        for(String cur:d){
            if(cur.length()<resLength||!isMatch(cur,s))
                continue;
            if(cur.length()>resLength||cur.compareTo(result)<0)
                result=cur;
            resLength=cur.length();
        }
        return result;
    }

    private boolean isMatch(String cur,String s){
        int index1=0,index2=0;
        while(index1<cur.length()&&index2<s.length()){
            if(cur.charAt(index1)==s.charAt(index2))
                index1++;
            index2++;
        }
        return index1==cur.length();
    }
}
