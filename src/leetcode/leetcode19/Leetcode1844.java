package leetcode.leetcode19;

public class Leetcode1844 {

    public String replaceDigits(String s) {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(i%2==0){
                sb.append(s.charAt(i));
            }else {
                char pre = s.charAt(i - 1);
                sb.append(getChar(pre,s.charAt(i)-'0'));
            }
        }
        return sb.toString();
    }

    private char getChar(char cur,int k){
        int big=(cur-'a'+k)%26;
        return (char)(big+'a');
    }
}
