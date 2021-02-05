package leetcode3;

import sun.lwawt.macosx.CSystemTray;

import java.util.Arrays;

public class Leetcode214 {
    /*Description
    * 给定一个字符串 s，你可以通过在字符串前面添加字符将其转换为回文串。找到并返回可以用这种方式转换的最短回文串。
     * */

    /*Solution
    * 可以使用马拉车算法求回文串
    * */

    public String shortestPalindrome(String s) {
        if(s==null||s.length()==0)
            return s;
        int length=s.length()*2+3;
        char[] c=new char[length];
        int[] dp=new int[length];
        c[0]='&';c[length-1]='^';
        for(int i=0;i<s.length();i++) {
            c[i*2+1]='.';
            c[i * 2 + 2] = s.charAt(i);
        }
        c[length-2]='.';
        int right=-1,mid=-1;
        for(int i=1;i<length-1;i++){
            if(i>=right){
                int r=i+1,l=i-1;
                while(c[r]==c[l]){
                    r++;l--;
                }
                right=r;
                mid=i;
                dp[i]=right-mid;
            }else {
                int symmetry=mid*2-i;
                int left=mid*2-right;
                if(symmetry -left>dp[symmetry])
                    dp[i]=dp[symmetry];
                else{
                    int l=i*2-right;
                    while(c[right]==c[l]){
                        right++;
                        l--;
                    }
                    mid=i;
                    dp[i]=right-i;
                }
            }
        }
        int index=length-3;
        for(;index>=2;index--){
            if(dp[index]==index)
                break;
        }
        StringBuilder sb=new StringBuilder();
        for(index--;index<s.length();index++)
            sb.append(s.charAt(index));
        return sb.reverse().append(s).toString();
    }
    private void system(int[] dp,char[] c){
        for(int i=0;i<dp.length;i++)
            System.out.print(dp[i]+" ");
        System.out.println();
        for(char cur:c)
            System.out.print(cur+" ");
    }
    public static void main(String[] args){
        System.out.println(new Leetcode214().shortestPalindrome("aabcd"));
    }
}
