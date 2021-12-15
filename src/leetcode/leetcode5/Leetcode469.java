package leetcode.leetcode5;

import java.util.List;

public class Leetcode469 {

    public boolean isConvex(List<List<Integer>> points) {
        int flag=0;
        for(int i=0;i<points.size();i++){
            int i1=i;
            int i2=(i1+1)%points.size();
            int i3=(i2+1)%points.size();

            int x1=points.get(i2).get(0)-points.get(i1).get(0);
            int x2=points.get(i3).get(0)-points.get(i1).get(0);

            int y1=points.get(i2).get(1)-points.get(i1).get(1);
            int y2=points.get(i3).get(1)-points.get(i1).get(1);

            int cur=x1*y2-x2*y1;
            if(cur==0)
                continue;
            if(flag==0)
                flag=cur>0?1:-1;
            if(flag*cur<0)
                return false;
        }
        return true;
    }
}
