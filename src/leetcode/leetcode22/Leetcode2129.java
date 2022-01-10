package leetcode.leetcode22;

import java.util.Locale;

public class Leetcode2129 {

    public String capitalizeTitle(String title) {
        String[] t=title.split(" ");

        StringBuilder result=new StringBuilder();
        for(int i=0;i<t.length;i++){
            t[i] = t[i].toLowerCase();
            if(t[i].length()>2){
                t[i] = (char)(t[i].charAt(0)-'a'+'A')+t[i].substring(1);
            }

            result.append(" ").append(t[i]);
        }
        return result.substring(1);
    }
}
