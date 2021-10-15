package leetcode.leetcode14;

public class Leetcode1309 {

    public String freqAlphabets(String s) {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(i<s.length()-2&&s.charAt(i+2)=='#'){
                int cur=Integer.parseInt(s.substring(i,i+2));
                sb.append((char)(cur-10+'j'));
                i+=2;
            }else
                sb.append((char)(s.charAt(i)-'1'+'a'));
        }
        return sb.toString();
    }
}
