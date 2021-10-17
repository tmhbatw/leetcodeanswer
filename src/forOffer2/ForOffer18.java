package forOffer2;

import java.util.Locale;

public class ForOffer18 {
    public boolean isPalindrome(String s) {
        int l=0,r=s.length()-1;
        s=s.toLowerCase();
        while(l<r){
            if(!isChar(s.charAt(l))) {
                l++;
                continue;
            }
            if(!isChar(s.charAt(r))){
                r--;
                continue;
            }
            if(s.charAt(l)!=s.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }

    private boolean isChar(char cur){
        return cur<='z'&&cur>='a'||cur>='0'&&cur<='9';
    }
}
