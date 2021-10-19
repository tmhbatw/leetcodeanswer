package forOffer2;

public class ForOffer92 {

    public int minFlipsMonoIncr(String s) {
        int length=s.length();
        int[] sum=new int[length+1];
        for(int i=0;i<length;i++){
            if(s.charAt(i)=='1')
                sum[i+1]=sum[i]+1;
            else
                sum[i+1]=sum[i];
        }
        int result=length-sum[length];
        for(int i=0;i<length;i++){
            System.out.println(sum[i]+(length-i-1-(sum[length]-sum[i])));
            result=Math.min(result,sum[i]+(length-i-1-(sum[length]-sum[i])));
        }
        return result;
    }
}
