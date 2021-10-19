package forOffer2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ForOffer37 {

    public int[] asteroidCollision(int[] asteroids) {
        List<Integer> res=new ArrayList<>();
        Stack<Integer> s=new Stack<>();
        for(int cur:asteroids){
            if(cur<0){
                cur=-cur;
                boolean flag=true;
                while(!s.isEmpty()){
                    if(s.peek()>cur) {
                        flag=false;
                        break;
                    }
                    else if(s.peek()==cur) {
                        flag=false;
                        s.pop();
                    }
                    else
                        s.pop();
                }
                if(flag)
                    res.add(-cur);
            }else
                s.add(cur);
        }
        res.addAll(s);
        int[] result=new int[res.size()];
        for(int i=0;i<res.size();i++)
            result[i]=res.get(i);
        return result;
    }
}
