package forOffer;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class forOffer45 {
    /*Description
    *输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
     * */

    public String minNumber(int[] nums) {
        String[] num=new String[nums.length];
        for(int i=0;i<nums.length;i++)
            num[i]=String.valueOf(nums[i]);
        Arrays.sort(num, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1+o2).compareTo(o2+o1);
            }
        });
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<nums.length;i++)
            sb.append(num[i]);
        return sb.toString();
    }
}
