package forOffer2;

public class ForOffer32 {

    public boolean isAnagram(String s, String t) {
        if(s.equals(t))
            return false;
        int[] num1=getNum(s);
        int[] num2=getNum(t);
        for(int i=0;i<26;i++){
            if(num1[i]!=num2[i])
                return false;
        }
        return true;
    }

    private int[] getNum(String s){
        int[] num=new int[26];
        for(int i=0;i<s.length();i++){
            num[s.charAt(i)-'a']++;
        }
        return num;
    }
}
