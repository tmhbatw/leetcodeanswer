package forOffer2;

import java.util.Arrays;

public class ForOffer76 {

    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
}
