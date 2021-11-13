package leetcode.leetcode8;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leetcode735 {

    public int[] asteroidCollision(int[] asteroids) {
        List<Integer> list=new ArrayList<>();
        Stack<Integer> s=new Stack<>();
        for(int num:asteroids){
            if(num>0){
                s.add(num);
            }else {
                boolean add=true;
                num=-num;
                while (!s.isEmpty()&&add) {
                    if(s.peek()>num)
                        add=false;
                    else if(s.peek()==num){
                        s.pop();
                        add=false;
                    }
                    else
                        s.pop();
                }
                if(add)
                    list.add(-num);
            }
        }
        list.addAll(s);
        int[] res=new int[list.size()];
        for(int i=0;i<res.length;i++)
            res[i]=list.get(i);
        return res;
    }
}
