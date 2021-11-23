package leetcode.leetcode21;

public class Leetcode2047 {

    public int countValidWords(String sentence) {
        String[] s=sentence.split(" ");

        int result=0;
        for(String str:s){
            if(isStr(str)){
                result++;
            }
        }
        return result;
    }

    private boolean isStr(String s) {
        if (s.length() == 0)
            return false;
        if (s.contains("-")) {
            if (s.charAt(0) == '-' || s.charAt(s.length() - 1) == '-')
                return false;
            String[] ss = s.split("-");
            if (ss.length != 2)
                return false;
            String sss=ss[0];
            int l=sss.length()-1;
            if(sss.charAt(l)>'z'||sss.charAt(l)<'a')
                return false;
            sss=ss[1];
            if(sss.length()==1){
                if(sss.charAt(0)>'z'||sss.charAt(0)<'a')
                    return false;
            }

            return isString(ss[0]) && isString(ss[1]);
        }
        return isString(s);
    }

    private boolean isString(String s){
        int l=s.length();
        if(s.charAt(l-1)<='9'&&s.charAt(l-1)>='0')
            return false;
        for(int i=0;i<l-1;i++){
            if(s.charAt(i)>'z'||s.charAt(i)<'a')
                return false;
        }
        return true;
    }
}
