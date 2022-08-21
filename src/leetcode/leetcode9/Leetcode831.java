package leetcode.leetcode9;

public class Leetcode831 {

    public String maskPII(String s) {
        if(s.contains("@")){
            return maskEmail(s);
        }

        return maskNumber(s);
    }

    private String maskEmail(String s){
        int index=s.indexOf("@");
        String result = s.charAt(0)+"*****"+s.charAt(index-1)+s.substring(index);
        char[] c=result.toCharArray();
        for(int i=0;i<c.length;i++){
            if(c[i]<='Z'&&c[i]>='A'){
                c[i]=(char)(c[i]-'A'+'a');
            }
        }
        return new String(c);
    }
    private String maskNumber(String s){
        String number = "";
        for(char c:s.toCharArray()){
            if(c<='9'&&c>='0')
                number += c;
        }

        String last=number.substring(number.length()-4);
        switch (number.length()){
            case 10:
                return "***-***-"+last;
            case 11:
                return "+*-***-***-"+last;
            case 12:
                return "+**-***-***-"+last;
            default:
                return "+***-***-***-"+last;
        }
    }

}
