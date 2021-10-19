package forOffer2;

public class ForOffer20 {

    public int countSubstrings(String s) {
        int length=s.length();
        boolean[][] res=new boolean[length][length];
        for(int i=0;i<length;i++){
            res[i][i]=true;
            if(i<length-1&&s.charAt(i)==s.charAt(i+1))
                res[i][i+1]=true;
        }
        for(int l=2;l<length;l++){
            for(int i=0;i<length-l;i++){
                int j=i+l;
                if(s.charAt(i)==s.charAt(j)&&res[i+1][j-1])
                    res[i][j]=true;
            }
        }
        int result=0;
        for(int i=0;i<length;i++){
            for(int j=i;j<length;j++){
                if(res[i][j])
                    result++;
            }
        }
        return result;
    }
}
