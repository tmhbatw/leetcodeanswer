package leetcode.leetcode6;

import java.util.*;

public class Leetcode599 {
    /*Description
    * 假设Andy和Doris想在晚餐时选择一家餐厅，并且他们都有一个表示最喜爱餐厅的列表，每个餐厅的名字用字符串表示。
    * 你需要帮助他们用最少的索引和找出他们共同喜爱的餐厅。 如果答案不止一个，
    * 则输出所有答案并且不考虑顺序。 你可以假设总是存在一个答案。
    * */

    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String,Integer> map=new HashMap<>();
        for(int i=0;i<list1.length;i++){
            map.put(list1[i],i);
        }
        int curSum=Integer.MAX_VALUE;
        List<String> result=new ArrayList<>();
        for(int i=0;i<list2.length;i++){
            if(map.containsKey(list2[i])){
                if(curSum>map.get(list2[i])+i){
                    curSum=map.get(list2[i])+i;
                    result=new ArrayList<>();
                }
                if(curSum==(map.get(list2[i])+i))
                    result.add(list2[i]);
            }
        }
        return  result.toArray(new String[0]);
    }
}
