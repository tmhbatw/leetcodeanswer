package forOffer2;

import java.util.Stack;

public class ForOffer38 {

    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> s=new Stack<>();
        int length=temperatures.length;

        int[] res=new int[length];
        for(int j=length-1;j>=0;j--){
            while(!s.isEmpty()&&s.peek()[0]<=temperatures[j])
                s.pop();
            if(!s.isEmpty())
                res[j]=s.peek()[1]-j;
            s.add(new int[]{temperatures[j],j});
        }

        return res;
    }

}
