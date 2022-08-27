package leetcode.leetcode5;

import java.util.Arrays;

public class Leetcode467 {

    public int findSubstringInWraproundString(String p) {
        int[] t=new int[26];
        for(int i=0;i<p.length();i++){
            int start=i;
            while(i<p.length()-1&&match(p.charAt(i),p.charAt(i+1)))
                i++;
            int cur=i-start+1;
            for(int j=0;j<Math.min(26,cur);j++){
                int index=(p.charAt(start)-'a'+j)%26;

                t[index]=Math.max(t[index],cur-j);
            }
        }

        return Arrays.stream(t).sum();
    }

    private boolean match(char c1,char c2){
        return c1=='z'&&c2=='a'||c2-c1==1;
    }

}
