package leetcode.leetcode21;

import java.util.ArrayList;
import java.util.List;

public class Leetcode2080 {

    class RangeFreqQuery {

        List<List<Integer>> list;
        public RangeFreqQuery(int[] arr) {
            this.list=new ArrayList<>();
            for(int i=0;i<=10000;i++){
                list.add(new ArrayList<>());
            }
            for(int i=0;i<arr.length;i++){
                list.get(arr[i]).add(i);
            }
        }

        public int query(int left, int right, int value) {
            List<Integer> list=this.list.get(value);
            if(list.size()==0)
                return 0;

            if(list.get(0)>right||list.get(list.size()-1)<left)
                return 0;

            int l1=0,l2=list.size()-1;
            while(l1<l2){
                int mid=(l1+l2+1)/2;
                if(list.get(mid)<=right)
                    l1=mid;
                else{
                    l2=mid-1;
                }
            }

            int r1=0,r2=list.size()-1;
            while(r1<r2){
                int mid=(r1+r2)/2;
                if(list.get(mid)>=left)
                    r2=mid;
                else
                    r1=mid+1;
            }
            return Math.max(0,l1-r1+1);
        }
    }


}
