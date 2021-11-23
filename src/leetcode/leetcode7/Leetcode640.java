package leetcode.leetcode7;

public class Leetcode640 {

    public String solveEquation(String equation) {
        String[] s=equation.split("=");
        int[] r1=getRes(s[0]);
        int[] r2=getRes(s[1]);

        r1[0]-=r2[0];
        r1[1]=r2[1]-r1[1];
        if(r1[0]==0&&r1[1]==0)
            return "Infinite solutions";
        if(r1[0]==0)
            return "No solution";
        return "x="+r1[1]/r1[0];
    }

    private int[] getRes(String s){
        boolean positive=true;
        int length=s.length();
        int[] res=new int[2];

        for(int i=0;i<length;i++){
            if(s.charAt(i)=='+')
                positive=true;
            else if(s.charAt(i)=='-')
                positive=false;
            else if(s.charAt(i)=='x')
                res[0]+=positive?1:-1;
            else{
                int val=s.charAt(i)-'0';
                while(i<length-1&&s.charAt(i+1)<='9'&&s.charAt(i+1)>='0')
                    val=val*10+s.charAt(++i)-'0';
                if(i<length-1&&s.charAt(i+1)=='x'){
                    res[0]+=positive?val:-val;
                    i++;
                }else
                    res[1]+=positive?val:-val;
            }
        }
        return res;
    }
}
