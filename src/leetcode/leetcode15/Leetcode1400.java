package leetcode.leetcode15;

public class Leetcode1400 {

    public boolean canConstruct(String s, int k) {
        if(s.length()<k)
            return false;

        int[] num=new int[26];
        for(char c:s.toCharArray())
            num[c-'a']++;

        int even=0;
        for(int n:num){
            if(n%2==1)
                even++;
        }

        if(even>k)
            return false;

        int expect=(k-even+1)/2*2+even;
        return expect<=s.length();

    }
}
