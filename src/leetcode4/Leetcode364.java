package leetcode4;

import datastructure.NestedInteger;

import java.util.List;

public class Leetcode364 {
    /*Description
    * 给一个嵌套整数序列，请你返回每个数字在序列中的加权和，它们的权重由它们的深度决定。
    * 序列中的每一个元素要么是一个整数，要么是一个序列（这个序列中的每个元素也同样是整数或序列）。
    * 与 前一个问题 不同的是，前一题的权重按照从根到叶逐一增加，而本题的权重从叶到根逐一增加。也就是说，在本题中，
    * 叶子的权重为1，而根拥有最大的权重。
    * */
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int depth=0;
        for(NestedInteger nestedInteger:nestedList){
            depth=Math.max(getDepth(nestedInteger),depth);
        }
        depth++;
        int result=0;
        for(NestedInteger nestedInteger:nestedList){
            if(nestedInteger.isInteger()){
                result+=getSum(nestedInteger,depth-1);
            }
            else{
                result+=getSum(nestedInteger,depth-1);
            }
        }
        return result;
    }

    private int getDepth(NestedInteger nestedInteger){
        if(nestedInteger.isInteger())
            return 1;
        int depth=0;
        for(NestedInteger list:nestedInteger.getList()){
            depth=Math.max(depth,getDepth(list));
        }
        return depth+1;
    }

    private int getSum(NestedInteger cur,int depth){
        if(cur.isInteger())
            return depth*cur.getInteger();
        int result=0;
        for(NestedInteger curNested:cur.getList())
            result+=getSum(curNested,depth-1);
        return result;
    }
}
