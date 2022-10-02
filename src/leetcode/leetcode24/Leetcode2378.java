package leetcode.leetcode24;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode2378 {

    class Tree{
        int index;
        int val;
        List<Tree> children;
        public Tree(int index,int val){
            this.index=index;
            this.val=val;
            this.children=new ArrayList<>();
        }
    }

    Tree root;
    public long maxScore(int[][] edges) {
        Map<Integer,Tree> map=new HashMap<>();
        for(int i=0;i<edges.length;i++){
            //根结点
            if(edges[i][0]==-1){
                map.putIfAbsent(i,new Tree(i,0));
                root=map.get(i);
            }else{
                map.putIfAbsent(i,new Tree(i,0));
                map.get(i).val=edges[i][1];
                map.putIfAbsent(edges[i][0],new Tree(edges[i][0],0));
                map.get(edges[i][0]).children.add(map.get(i));
            }
        }

        return getRes(root)[0];
    }

    //result[0]表示用一个节点，result[1]表示一个节点都不用
    private long[] getRes(Tree root){
        if(root==null)
            return new long[2];
        long result2=0;
        List<long[]> list=new ArrayList<>();
        //可以连接某一个节点，但是其他节点都不能连
        for(Tree child:root.children){
            long[] cur=getRes(child);
            list.add(cur);
            result2+=cur[0];
        }

        long result1=result2;
        for(int i=0;i<list.size();i++){
            long[] cur=list.get(i);
            result1=Math.max(result1,result2-cur[0]+cur[1]+root.children.get(i).val);
        }

        //System.out.println(root.index+" "+result1+" "+result2);

        return new long[]{result1,result2};
    }

}
