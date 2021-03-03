package interview;

public class Problem1_2 {
    /*Description
    * 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
    * */

    public boolean CheckPermutation(String s1, String s2) {
        if(s1.length()!=s2.length())
            return false;
        int[] c=new int[128];
        for(int i=0;i<s1.length();i++){
            c[s1.charAt(i)]++;
        }
        for(int i=0;i<s2.length();i++){
            c[s2.charAt(i)]--;
            if(c[s2.charAt(i)]==-1)
                return false;
        }
        return true;
    }
}
