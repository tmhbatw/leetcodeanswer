package leetcode3;

public class Leetcode266 {
    /*Description
    * 给定一个字符串，判断该字符串中是否可以通过重新排列组合，形成一个回文字符串。
    * */

    public boolean canPermutePalindrome(String s) {
        int[] num=new int[128];
        for(int i=0;i<s.length();i++)
            num[s.charAt(i)]++;
        boolean medium=false;
        for(int i=0;i<128;i++){
            if(num[i]%2==1&&medium)
                return false;
            else if(num[i]%2==1)
                medium=true;
        }
        return true;
    }
}
