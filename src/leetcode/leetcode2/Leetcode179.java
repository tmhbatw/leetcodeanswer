package leetcode.leetcode2;

import java.util.Arrays;
import java.util.Comparator;

public class Leetcode179 {
    /*Description
    * 给定一组非负整数 nums，重新排列它们每个数字的顺序（每个数字不可拆分）使之组成一个最大的整数。
    * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
    * */

    public String largestNumber(int[] nums) {
        if(nums==null||nums.length==0)
            return "";
        Comparator<Integer> c=new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String oo1=o1+""+o2;
                String oo2=o2+""+o1;
                return -oo1.compareTo(oo2);
            }
        };
        int length=nums.length;
        Integer[] n=new Integer[length];
        for(int i=0;i<length;i++){
            n[i]=nums[i];
        }
        Arrays.sort(n,c);
        StringBuilder sb=new StringBuilder();
        if(n[0]==0)
            return "0";
        for(int i=0;i<length;i++)
            sb.append(n[i]);
        return sb.toString();
    }
}
