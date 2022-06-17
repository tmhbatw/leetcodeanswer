package leetcode.leetcode23;

public class Leetcode2299 {

    public boolean strongPasswordCheckerII(String password) {
        if(password.length()<8)
            return false;

        int numCount = 0 ;
        int smallCount = 0;
        int bigCount = 0;
        int specialCount = 0;

        String special = "!@#$%^&*()-+";
        for(int i=0;i<password.length();i++){
            if(i>=1&&password.charAt(i)==password.charAt(i-1))
                return false;
            char cur = password.charAt(i);
            if(cur<='9'&&cur>='0')
                numCount++;
            if(cur<='Z'&&cur>='A')
                bigCount++;
            if(cur<='z'&&cur>='a')
                smallCount++;

            if(special.contains(cur+""))
                specialCount++;
        }

        return numCount>=1&&smallCount>=1&&bigCount>=1&&specialCount>=1;
    }
}
