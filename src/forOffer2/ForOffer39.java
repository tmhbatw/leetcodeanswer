package forOffer2;

import java.util.*;

public class ForOffer39 {

    public int minimumSwitchingTimes(int[][] source, int[][] target) {
        List<Integer> l1=getList(source);
        List<Integer> l2=getList(target);

        int index=0;
        int miss=0;
        for (Integer integer : l1) {
            while (index < l2.size() && l2.get(index) < integer)
                index++;
            if (index == l2.size() || !l2.get(index).equals(integer))
                miss++;
            else
                index++;
        }
        return miss;
    }

    private List<Integer> getList(int[][] source){
        List<Integer> list=new ArrayList<>();
        for(int[] cur:source){
            for(int num:cur)
                list.add(num);
        }
        Collections.sort(list);
        return list;
    }

    public int largestRectangleArea(int[] heights) {
        int[] right=new int[heights.length];
        Stack<int[]> s=new Stack<>();
        s.add(new int[]{Integer.MIN_VALUE,heights.length});
        for(int j=heights.length-1;j>=0;j--){
            while(s.peek()[0]>=heights[j])
                s.pop();
            right[j]=s.peek()[1]-j;
            s.add(new int[]{heights[j],j});
        }

        int[] left=new int[heights.length];
        s=new Stack<>();
        s.add(new int[]{Integer.MIN_VALUE,-1});
        int result=0;
        for(int i=0;i<heights.length;i++){
            while(s.peek()[0]>=heights[i]){
                s.pop();
            }
            left[i]=i-s.peek()[1];
            s.add(new int[]{heights[i],i});
            result=Math.max(result,heights[i]*(left[i]+right[i]-1));
        }

        return result;
    }
}
