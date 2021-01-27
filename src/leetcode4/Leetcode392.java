package leetcode4;

public class Leetcode392 {
    /*Description
    * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
    * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。
    * （例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
    * */

    public boolean isSubsequence(String s, String t) {
        if(s==null)
            return true;
        if(t==null)
            return false;
        int index=0;
        int tLength=t.length();
        for(int i=0;i<s.length();i++){
            char cur=s.charAt(i);
            if(index==tLength)
                return false;
            while(t.charAt(index)!=cur){
                index++;
                if(index==tLength)
                    return false;
            }
            index++;
        }
        return true;
    }
}
