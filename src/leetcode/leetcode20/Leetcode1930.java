package leetcode.leetcode20;

import leetcode.leetcode24.Leetcode2336;

import java.util.HashSet;
import java.util.Set;

public class Leetcode1930 {

    public int countPalindromicSubsequence(String s) {
        int[] time=new int[26];
        int pre=0;
        int post=0;
        for(int i=s.length()-1;i>=0;i--){
            int index=s.charAt(i)-'a';
            if(time[index]==0)
                post|=1<<index;
            time[index]++;
        }

        Set<Integer> result=new HashSet<>();
        for(int i=0;i<s.length();i++){
            int index=s.charAt(i)-'a';

            time[index]--;
            if(time[index]==0)
                post-=1<<index;

            int cur=pre&post;

            int ten=0;
            while(cur>0){
                int last=cur%2;
                if(last==1){
                    System.out.println((char)(ten+'a')+""+(char)(index+'a'));
                    result.add(ten*30+index);
                }
                ten++;
                cur/=2;
            }

            pre |=1<<index;

        }

        System.out.println(result);
        return result.size();
    }

    public static void main(String[] args){
        new Leetcode1930().countPalindromicSubsequence("aba");
    }


}
