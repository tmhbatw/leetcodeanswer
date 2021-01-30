package leetcode5;

import java.util.Arrays;
import java.util.Comparator;

public class Leetcode451 {
    /*Description
    * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
    * */

    public String frequencySort(String s) {
        int[][] num=new int[128][2];
        for(int i=0;i<s.length();i++)
            num[s.charAt(i)][1]++;
        for(int i=0;i<128;i++)
            num[i][0]=i;
        Arrays.sort(num, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1]-o1[1];
            }
        });
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<128;i++){
            while(num[i][1]-->0)
                sb.append((char)num[i][0]);
        }
        return sb.toString();
    }
}
