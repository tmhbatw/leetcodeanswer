package forOffer2;

public class ForOffer19 {


    public boolean validPalindrome(String s) {
        for(int i=0;i<s.length()/2;i++){
            if(s.charAt(i)!=s.charAt(s.length()-1-i))
                return validPalindrome(s,i+1,s.length()-1-i)
                ||validPalindrome(s,i,s.length()-2-i);
        }
        return true;
    }

    private boolean validPalindrome(String s,int l,int r){
        while(l<r){
            if(s.charAt(l)!=s.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }

}
