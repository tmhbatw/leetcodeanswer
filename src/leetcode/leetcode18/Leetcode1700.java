package leetcode.leetcode18;

import java.util.Arrays;

public class Leetcode1700 {

    public int countStudents(int[] students, int[] sandwiches) {
        int number1= Arrays.stream(students).sum();
        int number0=students.length-number1;
        for(int i=0;i<sandwiches.length;i++){
            if(sandwiches[i]==0&&number0==0||sandwiches[i]==1&&number1==0){
                return sandwiches.length-i;
            }
            if(sandwiches[i]==0)
                number0--;
            else
                number1--;
        }
        return 0;
    }
}
