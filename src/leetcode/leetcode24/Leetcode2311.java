package leetcode.leetcode24;

public class Leetcode2311 {

    public int longestSubsequence(String s, int k) {
        int result =0 ;
        double cur =0;
        double kk = k;
        boolean one=true;
        for(int j=s.length()-1;j>=0;j--){
            if(s.charAt(j)=='0')
                result++;
            else{
                if(!one)
                    continue;
                if(cur+(Math.pow(2,result))<=kk) {
                    cur +=  Math.pow(2, result);
                    result++;
                }else
                    one = false;
            }
        }
        return result;
    }


}
