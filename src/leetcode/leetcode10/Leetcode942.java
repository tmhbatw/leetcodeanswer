package leetcode.leetcode10;

public class Leetcode942 {

    public int[] diStringMatch(String s) {
        int[] res=new int[s.length()+1];
        int l=0,r=s.length();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='I')
                res[i]=l++;
            else
                res[i]=r--;
        }
        res[s.length()]=l;
        return res;
    }
}
