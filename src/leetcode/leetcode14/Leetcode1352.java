package leetcode.leetcode14;

import java.util.ArrayList;
import java.util.List;

public class Leetcode1352 {

    class ProductOfNumbers {

        List<Integer> list=new ArrayList<>();
        List<Integer> sum=new ArrayList<>();
        int cur=0;
        public ProductOfNumbers() {
            sum.add(1);
        }

        public void add(int num) {
            list.add(num);
            cur++;
            if(cur==201){
                sum.add(num);
                cur=0;
            }else{
                sum.set(sum.size()-1,sum.get(sum.size()-1)*num);
            }
        }

        public int getProduct(int k) {
            int last=cur;
            int result = 1;
            if(k<=last){
                for(int j=list.size()-1;j>=(list.size()-k);j--)
                    result*=list.get(j);
                return result;
            }else{
                int mid=(k-last)/200;
                for(int j=sum.size()-1;j>=sum.size()-mid-1;j--)
                    result*=sum.get(j);
                int left=(k-last)%200;
                for(int i=list.size()-k;i<list.size()-k+left;i++)
                    result*=list.get(i);
                return result;
            }
        }
    }



}
