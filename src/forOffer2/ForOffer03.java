package forOffer2;

public class ForOffer03 {

    public int[] countBits(int n){
        int[] res=new int[n+1];
        int base=1;
        for(int i=1;i<=n;i++){
            if(i==base) {
                res[i] = 1;
                base*=2;
            }else{
                res[i]=1+res[i-base];
            }
        }
        return res;
    }
}
