package leetcode.leetcode4;

import java.util.ArrayList;
import java.util.List;

public class Leetcode390 {

    public int lastRemaining(int n) {
        List<Boolean> flag=new ArrayList<>();
        boolean even=true;
        while (n>1){
            if(even||n%2==1){
                flag.add(true);
            }else
                flag.add(false);

            even=!even;
            n/=2;
        }

        int result=1;
        for(int j=flag.size()-1;j>=0;j--){
            if(flag.get(j))
                result*=2;
            else
                result=result*2-1;
        }

        return result;
    }
}
