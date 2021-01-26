package leetcode4;

import datastructure.NestedInteger;

import java.util.List;

public class Leetcode339 {
    /*Description
    * 给定一个嵌套的整数列表nestedList ，每个元素要么是整数，要么是列表。同时，列表中元素同样也可以是整数或者是另一个列表。
    * 整数的 深度 是其在列表内部的嵌套层数。例如，嵌套列表[1,[2,2],[[3],2],1] 中每个整数的值就是其深度。
    * 请返回该列表按深度加权后所有整数的总和。
    * */

    public int depthSum(List<NestedInteger> nestedList) {
        int result=0;
        for(NestedInteger cur:nestedList){
            result+=getDepth(cur,0);
        }
        return result;
    }

    private int getDepth(NestedInteger cur,int depth){
        depth++;
        if(cur.isInteger())
            return depth*cur.getInteger();
        List<NestedInteger> list=cur.getList();
        int result=0;
        for(NestedInteger curr:list)
            result+=getDepth(curr,depth);
        return result;
    }
}
