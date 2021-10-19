package forOffer2;

import java.util.ArrayList;
import java.util.List;

public class ForOffer15 {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result=new ArrayList<>();
        String temp=p;
        p=s;
        s=temp;
        if(s.length()>p.length())
            return result;
        int[] num=getNum(s);
        int[] num2=new int[26];
        for(int i=0;i<s.length()-1;i++){
            num2[p.charAt(i)-'a']++;
        }
        for(int j=s.length()-1;j<p.length();j++){
            num2[p.charAt(j)-'a']++;
            if(isSame(num,num2))
                result.add(j-s.length()+1);
            num2[p.charAt(j-s.length()+1)-'a']--;
        }
        return result;
    }


    private int[] getNum(String s){
        int[] num=new int[26];
        for(int i=0;i<s.length();i++){
            num[s.charAt(i)-'a']++;
        }
        return num;
    }

    private boolean isSame(int[] num1, int[] num2){
        for(int i=0;i<26;i++){
            if(num1[i]!=num2[i])
                return false;
        }
        return true;
    }
}
