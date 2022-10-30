package leetcode.leetcode17;

public class Leetcode1616 {

    public boolean checkPalindromeFormation(String a, String b) {
        return isPalindrome(a,b)||isPalindrome(b,a)||isPalindrome2(a,b)||
                isPalindrome2(b,a);
    }

    private boolean isPalindrome(String a,String b){
        int length=a.length();
        boolean flag=true;
        for(int i=length/2-1;i>=0;i--){
            if(flag){
                if(a.charAt(i)!=a.charAt(length-i-1)){
                    flag=false;
                }
            }
            if(!flag){
                if(a.charAt(i)!=b.charAt(length-i-1))
                    return false;
            }
        }
        return true;
    }

    private boolean isPalindrome2(String a, String b){
        int length=a.length();
        boolean flag=true;
        for(int i=(length+1)/2;i<length;i++){
            if(flag){
                if(a.charAt(i)!=a.charAt(length-i-1)){
                    flag=false;
                }
            }
            if(!flag){
                if(a.charAt(i)!=b.charAt(length-i-1))
                    return false;
            }
        }
        return true;
    }

    private boolean isPalindrome(String s){
        for(int i=0;i<s.length()/2;i++){
            if(s.charAt(i)!=s.charAt(s.length()-i-1))
                return false;
        }
        return true;
    }
}
