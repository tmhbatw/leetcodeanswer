package leetcode.leetcode15;

public class Leetcode1446 {

    public int maxPower(String s) {
        int result=0;
        int length=s.length();
        for(int i=0;i<s.length();i++){
            char cur=s.charAt(i);
            int start=i;
            while(i<length-1&&s.charAt(i+1)==cur){
                i++;
            }
            result=Math.max(result,i-start+1);
        }
        return result;
    }
}
