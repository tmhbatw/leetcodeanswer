package leetcode.leetcode21;

import datastructure.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Leetcode2049 {

    long result=0;
    int res=0;
    int time;
    public int countHighestScoreNodes(int[] parents) {
        Map<Integer, TreeNode> map=new HashMap<>();
        int root = 0;

        for(int i=0;i<parents.length;i++){
            int father = parents[i];
            if(father==-1){
                root=i;
                continue;
            }
            int cur = i;
            map.putIfAbsent(father,new TreeNode(father));
            map.putIfAbsent(cur,new TreeNode(cur));

            if(map.get(father).left!=null)
                map.get(father).right=map.get(cur);
            else
                map.get(father).left=map.get(cur);
        }

        this.time=parents.length;
        getRes(map.get(root));

        return res;
    }

    private int getRes(TreeNode cur){
        if(cur==null)
            return 0;
        int left=getRes(cur.left);
        int right=getRes(cur.right);
        int last=time-left-right-1;

        long score= (long) Math.max(left, 1) *Math.max(right,1)*Math.max(last,1);
        if(result<score){
            result=score;
            res=0;
        }
        if(result==score)
            res++;
        return left+right+1;
    }
}
