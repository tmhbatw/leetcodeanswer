package interview;

import java.util.ArrayList;
import java.util.List;

public class Problem17_17 {
    /*Description
    * 给定一个较长字符串big和一个包含较短字符串的数组smalls，设计一个方法，
    * 根据smalls中的每一个较短字符串，对big进行搜索。
    * 输出smalls中的字符串在big里出现的所有位置positions，其中positions[i]为smalls[i]出现的所有位置。
    * */

    public int[][] multiSearch(String big, String[] smalls) {
        List<List<Integer>> list=new ArrayList<>();
        for(String cur:smalls){
            List<Integer> lis=new ArrayList<>();
            int index;
            int pre=0;
            while((index=big.indexOf(cur,pre))!=0){
                lis.add(index);
                pre=index;
            }
            list.add(lis);
        }
        int index=0;
        int[][] result=new int[list.size()][];
        for(List<Integer> curList:list){
            int[] cur=new int[curList.size()];
            for(int i=0;i<cur.length;i++)
                cur[i]=curList.get(i);
            result[index++]=cur;
        }
        return result;
    }
}
