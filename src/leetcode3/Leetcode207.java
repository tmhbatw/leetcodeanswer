package leetcode3;

import java.util.*;

public class Leetcode207 {
    /*Description
    * 你这个学期必须选修 numCourse 门课程，记为0到numCourse-1 。
    * 在选修某些课程之前需要一些先修课程。例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]
    * 给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习
    * */

    boolean[] reached;
    boolean[] wait;
    List<List<Integer>> list;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites==null||prerequisites.length==0)
            return true;
        reached=new boolean[numCourses];
        wait=new boolean[numCourses];
        list=new ArrayList<>();
        for(int i=0;i<numCourses;i++)
            list.add(new ArrayList<>());
        for(int[] cur:prerequisites)
            list.get(cur[0]).add(cur[1]);
        for(int i=0;i<numCourses;i++){
            if(!dfs(i))
                return false;
        }
        return true;
    }

    private boolean dfs(int cur){
        if(reached[cur])
            return true;
        wait[cur]=true;
        List<Integer> curList=list.get(cur);
        for(int curr:curList){
            if(wait[cur]||!dfs(curr)) {
                wait[cur]=false;
                return false;
            }
        }
        wait[cur]=false;
        reached[cur]=true;
        return true;
    }


}
