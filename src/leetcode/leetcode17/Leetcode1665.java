package leetcode.leetcode17;

import java.util.Arrays;

public class Leetcode1665 {

    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks,(o1,o2)->{
            return (o2[1]-o2[0])-(o1[1]-o1[0]);
        });

        int result=0;
        for(int[] task:tasks)
            result+=task[0];
        int cur=result;
        for(int[] task:tasks){
            if(task[1]>cur){
                result+=task[1]-cur;
                cur=task[1];
            }
            cur-=task[0];
        }

        return result;
    }
}
