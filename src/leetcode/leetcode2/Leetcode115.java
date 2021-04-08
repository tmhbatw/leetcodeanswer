package leetcode.leetcode2;

public class Leetcode115 {
    /*Description
    * 给定一个字符串 s 和一个字符串 t ，计算在 s 的子序列中 t 出现的个数。
    * 字符串的一个 子序列 是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。
    * （例如，"ACE"是"ABCDE"的一个子序列，而"AEC"不是）题目数据保证答案符合 32 位带符号整数范围。
    * */

    public int numDistinct(String s, String t) {
        if(t==null||t.length()==0)
            return 1;
        if(s==null||s.length()==0)
            return 0;
        int sLength=s.length(),tLength=t.length();
        int[][] num=new int[tLength+1][sLength+1];
        for(int j=0;j<=sLength;j++)
            num[0][j]=1;
        for(int i=0;i<tLength;i++){
            char cur=t.charAt(i);
            for(int j=0;j<sLength;j++){
                num[i+1][j+1]+=num[i+1][j];
                if(s.charAt(j)==cur)
                    num[i+1][j+1]+=num[i][j];
            }
        }
        return num[tLength][sLength];
    }
}
