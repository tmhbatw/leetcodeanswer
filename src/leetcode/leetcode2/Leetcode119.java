package leetcode.leetcode2;

import java.util.ArrayList;
import java.util.List;

public class Leetcode119 {
    /*Description
    *给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
    * */

    public List<Integer> getRow(int rowIndex) {
        List<Integer> result=new ArrayList<>();
        result.add(1);
        if(rowIndex==0)
            return result;
        for(int i=1;i<=rowIndex;i++){
            List<Integer> cur=new ArrayList<>();
            cur.add(1);
            for(int j=0;j<i-1;j++){
                cur.add(result.get(j)+result.get(j+1));
            }
            cur.add(1);
            result=cur;
        }
        return result;
    }

}
