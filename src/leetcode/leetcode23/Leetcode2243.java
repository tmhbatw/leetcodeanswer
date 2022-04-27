package leetcode.leetcode23;

public class Leetcode2243 {

    public String digitSum(String s, int k) {
        while(s.length()>k){
            String temp = "";
            for(int i=0;i<s.length();i+=k){
                int cur=0;
                for(int j=i;j<Math.min(s.length(),i+k);j++){
                    cur+=s.charAt(j)-'0';
                }
                temp+=cur;
            }
            s=temp;
        }
        return s;
    }
}
