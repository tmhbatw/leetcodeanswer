package leetcode.leetcode2;

import java.util.ArrayList;
import java.util.List;

public class Leetcode118 {
    /*Description
    * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行
    * */

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result=new ArrayList<>();
        if(numRows==0)
            return result;
        List<Integer> res=new ArrayList<>();
        res.add(1);
        result.add(res);
        for(int i=1;i<numRows;i++){
            List<Integer> cur=new ArrayList<>();
            cur.add(1);
            for(int j=0;j<i-1;j++){
                cur.add(res.get(j)+res.get(j+1));
            }
            cur.add(1);
            result.add(cur);
            res=cur;
        }
        return result;
    }
}
