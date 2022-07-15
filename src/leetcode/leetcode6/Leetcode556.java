package leetcode.leetcode6;

import java.util.ArrayList;
import java.util.List;

public class Leetcode556 {

    public int nextGreaterElement(int n) {
        List<Integer> list=new ArrayList<>();

        int preMax=-1;
        while(n>0){
            int last=n%10;
            n/=10;

            if(last<preMax){
                for(int j=0;j<list.size();j++){
                    if(list.get(j)>last){
                        n=n*10+list.get(j);
                        list.set(j,last);
                        break;
                    }
                }
                for (Integer integer : list) {
                    if(n>214748364||n==214748364&&integer>7)
                        return -1;
                    n = n * 10 + integer;
                }

                return Math.max(-1,n);
            }

            list.add(last);
            preMax=last;
        }

        return -1;
    }
}
