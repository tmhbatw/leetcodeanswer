package leetcode.leetcode19;

public class Leetcode1859 {

    public String sortSentence(String s) {
        String[] ss=s.split(" ");
        String[] res=new String[ss.length];
        for(String cur:ss){
            int index=cur.charAt(cur.length()-1)-'1';
            res[index]=cur.substring(0,cur.length()-1);
        }
        StringBuilder sb=new StringBuilder();
        sb.append(res[0]);
        for(int i=1;i<res.length;i++)
            sb.append(" ").append(res[i]);
        return sb.toString();
    }
}
