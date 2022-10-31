package leetcode.leetcode17;

import java.util.HashSet;
import java.util.Set;

public class Leetcode1625 {


    public String findLexSmallestString(String s, int a, int b) {
        Set<Integer> set=new HashSet<>();
        int cur=0;
        String result=s;
        while(!set.contains(cur)){
            set.add(cur);
            cur+=b;
            cur%=s.length();

            String ss=s.substring(cur)+s.substring(0,cur);
            char[] c=ss.toCharArray();
            for(int i=0;i<10;i++){
                for(int ii=0;ii<c.length;ii+=2){
                    c[ii]=add(c[ii],a);
                }
                if(b%2==1) {
                    for (int j = 0; j < 10; j++) {
                        for (int ii = 1; ii < c.length; ii += 2) {
                            c[ii] = add(c[ii], a);
                        }
                        String curr = new String(c);
                        if (curr.compareTo(result) < 0) {
                            result = curr;
                        }
                    }
                }else{
                    String curr = new String(c);
                    if (curr.compareTo(result) < 0) {
                        result = curr;
                    }
                }
            }
        }

        return result;
    }

    private char add(char c, int a){
        int cur=c-'0'+a;
        if(cur>10){
            return (char)(c+a-10);
        }
        return (char)(c+a);
    }

}
