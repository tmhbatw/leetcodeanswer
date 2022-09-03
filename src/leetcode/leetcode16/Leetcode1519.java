package leetcode.leetcode16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode1519 {

    List<int[]> list=new ArrayList<>();
    List<List<Integer>> next=new ArrayList<>();
    boolean[] reached;
    String labels;
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        this.labels=labels;
        this.reached=new boolean[n];
        for(int i=0;i<n;i++) {
            list.add(new int[26]);
            next.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            next.get(edge[0]).add(edge[1]);
            next.get(edge[1]).add(edge[0]);
        }

        int[] result=new int[n];
        for(int i=0;i<n;i++){
            int[] cur=getRes(i,-1);
            System.out.println(Arrays.toString(cur));
            result[i]=getRes(i,-1)[labels.charAt(i)-'a'];
        }
        return result;
    }

    private int[] getRes(int root,int father){
        if(reached[root])
            return list.get(root);

        reached[root]=true;
        int[] res=list.get(root);
        for(int next:this.next.get(root)){
            if(next==father)
                continue;

            int[] n=getRes(next,root);
            for(int i=0;i<n.length;i++)
                res[i]+=n[i];
        }
        res[labels.charAt(root)-'a']++;
        return res;
    }



}
