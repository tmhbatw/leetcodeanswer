package leetcode.leetcode7;

public class Leetcode686 {
    public int repeatedStringMatch(String a, String b) {
        int time = (b.length()-1)/a.length()+1;
        String aa=getStr(a,time);
        if(aa.contains(b))
            return time;
        if((aa+a).contains(b))
            return time+1;
        return -1;
    }

    private String getStr(String a, int time){
        StringBuilder sb=new StringBuilder();
        while(time-->0){
            sb.append(a);
        }
        return sb.toString();
    }


}
