package leetcode.leetcode9;

public class Leetcode824 {


    public String toGoatLatin(String sentence) {
        String[] s=sentence.split(" ");
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length;i++){
            char last=s[i].charAt(0);
            if(last>='A'&&last<='Z')
                last= (char) (last-'A'+'a');
            if(last=='a'||last=='e'||last=='i'||last=='o'||last=='u')
                sb.append(s[i]);
            else {
                sb.append(s[i].substring(1)).append(s[i].charAt(0));
            }
            sb.append("ma").append(getA(i + 1));
            sb.append(" ");
        }
        return sb.substring(0,sb.length()-1);
    }

    private String getA(int number){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<number;i++)
            sb.append("a");
        return sb.toString();
    }
}
