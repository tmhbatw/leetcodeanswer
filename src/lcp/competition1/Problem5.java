package lcp.competition1;

public class Problem5 {
    public boolean checkOnesSegment(String s) {
        boolean flag=false;
        int length=s.length();
        for(int i=0;i<length;i++){
            if(s.charAt(i)=='1'){
                if(flag)
                    return false;
                flag=true;
                while(i<length-1&&s.charAt(i+1)=='1')
                    i++;
            }
        }
        return true;
    }
}
