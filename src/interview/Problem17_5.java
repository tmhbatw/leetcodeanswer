package interview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem17_5 {
    /*Description
    * 给定一个放有字符和数字的数组，找到最长的子数组，且包含的字符和数字的个数相同。
    * 返回该子数组，若存在多个最长子数组，返回左端点下标值最小的子数组。若不存在这样的数组，返回一个空数组。
    * */

    public String[] findLongestSubarray(String[] array) {
        Map<Integer,Integer> map=new HashMap<>();
        int result=0;
        int maxLength=0;
        map.put(0,-1);
        int curLength=0;
        for(int i=0;i<array.length;i++){
            char cur=array[i].charAt(0);
            if(cur<='9'&&cur>='0'){
                curLength++;
            }else{
                curLength--;
            }
            if(map.containsKey(curLength)){
                if(maxLength<i-map.get(curLength)){
                    result=map.get(curLength);
                    maxLength=i-map.get(curLength);
                }
            }else{
                map.put(curLength,i);
            }
        }
        String[] res=new String[maxLength];
        int index=0;
        for(int i=result+1;i<=result+maxLength;i++){
            res[index++]=array[i];
        }
        return res;
    }
}
