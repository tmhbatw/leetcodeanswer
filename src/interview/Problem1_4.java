package interview;

public class Problem1_4 {
    /*Description
    * 给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
    * 回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。
    * 回文串不一定是字典当中的单词。
    * */

    public boolean canPermutePalindrome(String s) {
        int[] num=new int[128];
        for(int i=0;i<s.length();i++)
            num[s.charAt(i)]++;
        boolean flag=false;
        for(int i=0;i<128;i++){
            if(num[i]%2==1){
                if(flag)
                    return false;
                flag=true;
            }
        }
        return true;
    }
}
