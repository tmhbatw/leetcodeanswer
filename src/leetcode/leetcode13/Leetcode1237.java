package leetcode.leetcode13;

import java.util.ArrayList;
import java.util.List;

public class Leetcode1237 {
     class CustomFunction {
         // Returns f(x, y) for any given positive integers x and y.
         // Note that f(x, y) is increasing with respect to both x and y.
         // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
         public int f(int x, int y){
             return 0;
         };
     };

    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        int i=z,j=1;
        List<List<Integer>> result=new ArrayList<>();
        while(i>=1&&j<=z){
            if(customfunction.f(j,i)<z)
                j++;
            else if(customfunction.f(j,i)>z)
                i--;
            else{
                List<Integer> list=new ArrayList<>();
                list.add(j);
                list.add(i);
                result.add(list);
                i--;
                j++;
            }
        }
        return result;
    }
}
