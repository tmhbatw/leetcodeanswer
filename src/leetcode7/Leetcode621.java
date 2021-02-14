package leetcode7;

public class Leetcode621 {
    /*Description
    * 给你一个用字符数组tasks 表示的 CPU 需要执行的任务列表。其中每个字母表示一种不同种类的任务。
    * 任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。在任何一个单位时间，CPU 可以完成一个任务，或者处于待命状态。
    * 然而，两个 相同种类 的任务之间必须有长度为整数 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。
    * 你需要计算完成所有任务所需要的 最短时间 。
    * */

    public int leastInterval(char[] tasks, int n) {
        int[] time=new int[26];
        for(char cur:tasks)
            time[cur-'A']++;
        int max=0;
        int maxTime=0;
        for(int i=0;i<26;i++){
            if(time[i]>max) {
                max = time[i];
                maxTime=1;
            }else if(time[i]==max)
                maxTime++;
        }
        return Math.max((n+1)*(max-1)+maxTime,tasks.length);
    }
}
