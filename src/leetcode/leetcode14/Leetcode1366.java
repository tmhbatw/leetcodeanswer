package leetcode.leetcode14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Leetcode1366 {

    public String rankTeams(String[] votes) {
        int[][] time=new int[26][26];

        for(String vote:votes){
            for(int i=0;i<vote.length();i++){
                time[i][vote.charAt(i)-'A']++;
            }
        }

        char[] res=votes[0].toCharArray();
        List<Character> l=new ArrayList<>();
        for(char c:res)
            l.add(c);

        Collections.sort(l,(o1, o2)->{
            for(int i=0;i<26;i++){
                int oo1=time[i][o1-'A'];
                int oo2=time[i][o2-'A'];
                if(oo1!=oo2)
                    return oo2-oo1;
            }
            return o1-o2;
        });

        StringBuilder sb=new StringBuilder();
        for(char c:l)
            sb.append(c);
        return sb.toString();
    }
}
