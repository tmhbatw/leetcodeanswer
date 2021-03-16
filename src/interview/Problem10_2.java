package interview;

import java.util.*;

public class Problem10_2 {
    /*Description
    * 编写一种方法，对字符串数组进行排序，将所有变位词组合在一起。变位词是指字母相同，但排列不同的字符串。
    * */

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();
        for(String cur:strs){
            char[] c=cur.toCharArray();
            Arrays.sort(c);
            String curr=new String(c);

            if(!map.containsKey(curr)){
                map.put(curr,new ArrayList<>());
            }
            List<String> list=map.get(curr);
            list.add(cur);
        }
        List<List<String>> list=new ArrayList<>();
        for(Map.Entry entry:map.entrySet()){
            int[] cur= (int[]) entry.getKey();
            System.out.println(Arrays.toString(cur));
            list.add((List<String>) entry.getValue());
        }
        return list;
    }
}
