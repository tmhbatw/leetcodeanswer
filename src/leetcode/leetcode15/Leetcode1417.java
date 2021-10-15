package leetcode.leetcode15;

public class Leetcode1417 {

    public String reformat(String s) {
        StringBuilder sb1=new StringBuilder();
        StringBuilder sb2=new StringBuilder();

        for(int i=0;i<s.length();i++){
            char cur=s.charAt(i);
            if(cur<='9'&&cur>='0')
                sb1.append(cur);
            else
                sb2.append(cur);
        }

        if(Math.abs(sb1.length()-sb2.length())>=2)
            return "";

        if(sb2.length()>sb1.length()){
            StringBuilder temp=sb1;
            sb1=sb2;
            sb2=temp;
        }

        StringBuilder result=new StringBuilder();
        for(int i=0;i<sb2.length();i++){
            result.append(sb1.charAt(i)).append(sb2.charAt(i));
        }

        if(sb1.length()>sb2.length())
            result.append(sb1.charAt(sb1.length()-1));

        return result.toString();
    }
}
