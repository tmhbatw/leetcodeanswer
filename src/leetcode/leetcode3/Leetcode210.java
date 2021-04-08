package leetcode.leetcode3;

import java.util.ArrayList;
import java.util.List;

public class Leetcode210 {
    /*Description
    * 现在你总共有 n 门课需要选，记为0到n-1。
    * 在选修某些课程之前需要一些先修课程。例如，想要学习课程 0 ，你需要先完成课程1 ，我们用一个匹配来表示他们: [0,1]
    * 给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。
    * 可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。
    * */

    boolean[] reached;
    boolean[] wait;
    List<List<Integer>> list;
    List<Integer> result;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(prerequisites==null||prerequisites.length==0) {
            int[] result=new int[numCourses];
            for(int i=0;i<numCourses;i++)
                result[i]=i;
        }
        reached=new boolean[numCourses];
        wait=new boolean[numCourses];
        list=new ArrayList<>();
        result=new ArrayList<>();
        for(int i=0;i<numCourses;i++)
            list.add(new ArrayList<>());
        for(int[] cur:prerequisites)
            list.get(cur[0]).add(cur[1]);
        for(int i=0;i<numCourses;i++){
            if(!dfs(i))
                return new int[0];
        }
        System.out.println(result);
        int[] result=new int[numCourses];
        for(int i=0;i<numCourses;i++)
            result[i]=this.result.get(i);
        return result;
    }

    private boolean dfs(int cur){
        if(reached[cur])
            return true;
        wait[cur]=true;
        List<Integer> curList=list.get(cur);
        for(int curr:curList){
            if(wait[curr]||!dfs(curr)) {
                wait[curr]=false;
                return false;
            }
        }
        wait[cur]=false;
        reached[cur]=true;
        result.add(cur);
        return true;
    }
}
