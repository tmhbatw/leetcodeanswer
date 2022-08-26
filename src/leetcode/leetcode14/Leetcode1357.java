package leetcode.leetcode14;

import java.util.HashMap;
import java.util.Map;

public class Leetcode1357 {

    class Cashier {

        int n;
        int index;
        double discount;
        Map<Integer,Integer> m;
        public Cashier(int n, int discount, int[] products, int[] prices) {
            this.n=n;
            this.index=0;
            this.discount = 1-discount*1.0/100;
            this.m=new HashMap<>(products.length);
            for(int i=0;i<products.length;i++)
                m.put(products[i],prices[i]);
        }

        public double getBill(int[] product, int[] amount) {
            double res=0;
            for(int i=0;i<product.length;i++){
                res+=m.get(product[i])*amount[i];
            }
            index++;
            if(index%n==0)
                res*=discount;
            return res;
        }
    }


}
