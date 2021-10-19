package forOffer2;

public class ForOffer14 {

    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length())
            return false;
        int[] num=getNum(s1);
        int[] num2=new int[26];
        for(int i=0;i<s1.length()-1;i++){
            num2[s2.charAt(i)-'a']++;
        }
        for(int j=s1.length()-1;j<s2.length();j++){
            num2[s2.charAt(j)-'a']++;
            if(isSame(num,num2))
                return true;
            num2[s2.charAt(j-s1.length()+1)-'a']--;
        }
        return false;
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
