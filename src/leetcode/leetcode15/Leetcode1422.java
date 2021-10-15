package leetcode.leetcode15;

public class Leetcode1422 {

    public int maxScore(String s) {
        if(s.length()<=1)
            return 0;
        int result=0;
        int right=0;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)=='1')
                right++;
        }
        int left=s.charAt(0)=='0'?1:0;
        result=left+right;
        for(int i=1;i<s.length()-1;i++){
            if(s.charAt(i)=='0')
                left++;
            else
                right--;
            result=Math.max(result,left+right);
        }
        return result;
    }
}
