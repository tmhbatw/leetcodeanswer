package leetcode.leetcode5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Leetcode497 {

    class Solution {
        List<Integer> list=new ArrayList<>();
        int[][] rects;
        int sum=0;

        public Solution(int[][] rects) {
            this.rects=rects;
            for(int[] rect:rects){
                int x = rect[2]-rect[0]+1;
                int y=rect[3]-rect[1]+1;
                sum += x*y;
                list.add(sum);
            }
            System.out.println(list);
        }

        public int[] pick() {
            int cur= (int) (Math.random()*sum);
            int l = 0,r=list.size()-1;
            while(l<r){
                int mid= (l+r)/2;
                if (list.get(mid)>cur)
                    r=mid;
                else{
                    l=mid+1;
                }
            }



            int val = cur-(l==0?0:list.get(l-1));
            int[] rect=rects[l];
            int x=rects[l][2]-rect[0]+1;
            int xx= val/x;
            int yy=val%x;

            return new int[]{rect[0]+yy,rect[1]+xx};
        }
    }


}
