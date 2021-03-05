package interview;

import java.util.ArrayList;
import java.util.List;

public class Problem8_4 {
    /*Description
    * 幂集。编写一种方法，返回某集合的所有子集。集合中不包含重复的元素。
    * 说明：解集不能包含重复的子集。
    * */

    List<List<Integer>> result;
    int[] num;
    int length;
    public List<List<Integer>> subsets(int[] nums) {
        result=new ArrayList<>();
        this.num=nums;
        this.length=nums.length;
        dfs(0,new ArrayList<>());
        return result;
    }

    private void dfs(int index,List<Integer> list){
        if(index==length){
            result.add(list);
            return;
        }
        dfs(index+1,list);
        List<Integer> curList=new ArrayList<>();
        curList.add(num[index]);
        dfs(index+1,curList);
    }
}
