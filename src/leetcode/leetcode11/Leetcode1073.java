package leetcode.leetcode11;

import java.util.ArrayList;
import java.util.List;

public class Leetcode1073 {

    public int[] addNegabinary(int[] arr1, int[] arr2) {
        List<Integer> result=new ArrayList<>();
        int i=arr1.length-1,j=arr2.length-1;

        int add=0;
        while(i>=0||j>=0||add!=0){
            int ii=i>=0?arr1[i--]:0;
            int jj=j>=0?arr2[j--]:0;

            int cur = ii+jj+add;
            if(cur==-1){
                add=1;
                result.add(1);
            }else {
                add = cur>=2?-1:0;
                result.add(cur%2);
            }
        }

        while(result.size()>1&&result.get(result.size()-1)==0)
            result.remove(result.size()-1);

        int[] res=new int[result.size()];
        for(i=0;i<res.length;i++)
            res[i]=result.get(res.length-1-i);
        return res;
    }
}
