package leetcode.leetcode13;

import java.util.ArrayList;
import java.util.List;

public class Leetcode1276 {

    // 4x+2y=n1
    //  x+ y=n2
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        List<Integer> list=new ArrayList<>();

        int x=(tomatoSlices-cheeseSlices*2)/2;
        int y=cheeseSlices-x;

        if(4*x+2*y==tomatoSlices&&x>=0&&y>=0){
            list.add(x);
            list.add(y);
            return list;
        }
        return list;
    }
}
