package leetcode.leetcode20;

public class Leetcode1957 {

    public String makeFancyString(String s) {
        int length=s.length();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            char cur=s.charAt(i);
            int start=i;
            while(i<length-1&&s.charAt(i+1)==cur)
                i++;
            if(i-start+1>=2)
                sb.append(cur).append(cur);
            else
                sb.append(cur);
        }
        return sb.toString();
    }
}
