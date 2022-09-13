package leetcode.leetcode22;

public class Leetcode2116 {

    public boolean canBeValid(String s, String locked) {
        if(s.length()%2==1)
            return false;
        int min=0;
        int max=0;

        for(int i=0;i<s.length();i++){
            if(locked.charAt(i)=='1'){
                if(s.charAt(i)=='(') {
                    min++;
                    max++;
                }else{
                    min=Math.max(0,min-1);
                    max--;
                }
                if(max<0)
                    return false;
            }else{
                min=Math.max(0,min-1);
                max++;
            }
        }
        return min<=0;
    }


}
