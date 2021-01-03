package leetcode1;

public class Leetcode87 {
    /*Description
    *给定一个字符串 s1，我们可以把它递归地分割成两个非空子字符串，从而将其表示为二叉树。
    * 在扰乱这个字符串的过程中，我们可以挑选任何一个非叶节点，然后交换它的两个子节点。
    * */

    public boolean isScramble(String s1, String s2) {
        if(s1==null)
            return true;
        if(s1.equals(s2))
            return true;
        int[] num1=getNum(s1),num2=getNum(s2);
        if(!isSame(num1,num2))
            return false;
        int length=s1.length();
        for(int i=1;i<length;i++){
            if(isScramble(s1.substring(0,i),s2.substring(0,i))&&isScramble(s1.substring(i),s2.substring(i))
                ||isScramble(s1.substring(0,i),s2.substring(length-i))&&isScramble(s1.substring(i),s2.substring(0,length-i)))
                return true;
        }
        return false;
    }

    private boolean isSame(int[] num1,int[] num2){
        for(int i=0;i<128;i++)
            if(num1[i]!=num2[i])
                return false;
        return true;
    }

    private int[] getNum(String s){
        int[] num=new int[128];
        for(int i=0;i<s.length();i++)
            num[s.charAt(i)]++;
        return num;
    }
}
