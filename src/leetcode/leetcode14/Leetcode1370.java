package leetcode.leetcode14;

public class Leetcode1370 {
    public String sortString(String s) {
        int[] num=new int[26];
        for(int i=0;i<s.length();i++){
            num[s.charAt(i)-'a']++;
        }
        StringBuilder sb=new StringBuilder();
        while(!isEmpty(num)){
            for(int i=0;i<26;i++){
                if(num[i]>0){
                    sb.append((char)(i+'a'));
                    num[i]--;
                }
            }
            for(int j=25;j>=0;j--){
                if(num[j]>0){
                    sb.append((char)(j+'a'));
                    num[j]--;
                }
            }
        }
        return sb.toString();
    }

    private boolean isEmpty(int[] num){
        for(int i=0;i<26;i++){
            if(num[i]>0)
                return false;
        }
        return true;
    }
}
