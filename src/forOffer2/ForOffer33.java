package forOffer2;

public class ForOffer33 {

    public int storeWater(int[] bucket, int[] vat) {
        if(allZero(vat))
            return 0;
        int result=Integer.MAX_VALUE;
        for(int i=1;i<=10000;i++){
            int cur=i;
            for(int j=0;j<bucket.length;j++){
                int minVal=(vat[j]-1)/i+1;
                System.out.println(minVal+" "+i);
                cur+=Math.max(0,bucket[j]-minVal);
            }
            result=Math.min(result,cur);
        }
        return result;
    }

    private boolean allZero(int[] val){
        for(int cur:val){
            if(cur==0)
                return false;
        }
        return true;
    }
}
