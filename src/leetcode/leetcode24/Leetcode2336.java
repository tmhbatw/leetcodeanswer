package leetcode.leetcode24;

import java.util.ArrayList;
import java.util.List;

public class Leetcode2336 {

    class SmallestInfiniteSet {

        List<Integer> list;

        public SmallestInfiniteSet() {
            this.list=new ArrayList<>();
            for(int i=1;i<=1001;i++)
                list.add(i);
        }

        public int popSmallest() {
            return list.remove(0);
        }

        public void addBack(int num) {
            if(num<list.get(0))
                list.add(0,num);
            int l =0,r=list.size();
            while(l<r){
                int mid = (l+r)/2;
                if(list.get(mid)==num)
                    return;
                if(list.get(mid)<num)
                    l=mid+1;
                else
                    r=mid;
            }
            list.add(l,num);
        }
    }

    public static void main(String[] args){
        new Leetcode2336().new SmallestInfiniteSet();
    }

}
