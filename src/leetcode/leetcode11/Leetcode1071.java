package leetcode.leetcode11;

public class Leetcode1071 {

    public String gcdOfStrings(String str1, String str2) {
        if(!(str1+str2).equals(str2+str1))
            return "";
        int i=0;
        for(;i<getLength(str1.length(),str2.length());i++){
            if(str1.charAt(i)!=str2.charAt(i))
                break;
        }
        return str1.substring(0,i);
    }

    private int getLength(int l1,int l2){
        int min=Math.min(l1,l2);
        int max=Math.max(l1,l2);
        if(max%min==0)
            return min;
        return getLength(min,max%min);
    }
}
