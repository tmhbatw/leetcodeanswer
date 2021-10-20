package forOffer2;

public class ForOffer70 {
    public int singleNonDuplicate(int[] nums) {
        int res=0;
        for(int cur:nums)
            res^=cur;
        return res;
    }
}
