package leetcode.leetcode10;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Leetcode946 {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> s=new Stack<>();
        int index=0;
        for(int num:popped){
            while(s.isEmpty()||s.peek()!=num){
                if(index==pushed.length)
                    return false;
                s.add(pushed[index++]);
            }
            s.pop();
        }
        return true;
    }
}
