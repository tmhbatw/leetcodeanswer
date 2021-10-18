package forOffer2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ForOffer40 {

    public int maxmiumScore(int[] cards, int cnt) {
        List<Integer> list1=new ArrayList<>();
        List<Integer> list2=new ArrayList<>();
        for(int cur:cards){
            if(cur%2==0)
                list2.add(cur);
            else
                list1.add(cur);
        }
        list1.sort(Comparator.reverseOrder());
        list2.sort(Comparator.reverseOrder());
        int[] sum1=new int[list1.size()+1];
        int[] sum2=new int[list2.size()+1];
        for(int i=1;i<sum1.length;i++){
            sum1[i]=sum1[i-1]+list1.get(i-1);
        }
        for(int i=1;i<sum2.length;i++){
            sum2[i]=sum2[i-1]+list2.get(i-1);
        }

        int result=0;
        int index=0;
        for(;index<=cnt;index+=2){
            int index2=cnt-index;
            if(index>list1.size()||index2>list2.size())
                continue;
            result=Math.max(result,sum1[index]+sum2[index2]);
        }

        return result;
    }
}
