package leetcode.leetcode16;

public class Leetcode1513 {

    public int numSub(String s) {
        int mod=1000000007;
        long cur=0;

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                int start=i;
                while(i<s.length()-1&&s.charAt(i+1)=='1'){
                    i++;
                }
                start = i-start+1;
                cur += (long)start*(start+1)/2;
                cur%=mod;
            }
        }
        return (int)cur;
    }

}
