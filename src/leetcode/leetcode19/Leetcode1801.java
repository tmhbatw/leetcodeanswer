package leetcode.leetcode19;

import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.Comparator;
import java.util.PrimitiveIterator;
import java.util.PriorityQueue;

public class Leetcode1801 {

    class Order {
        int time;
        int price;
        public Order(int time,int price){
            this.time=time;
            this.price=price;
        }
    }
    public int getNumberOfBacklogOrders(int[][] orders) {
        PriorityQueue<Order> buy=new PriorityQueue<>((o1,o2)-> o2.price-o1.price);
        PriorityQueue<Order> sell=new PriorityQueue<>(Comparator.comparingInt(o -> o.price));

        for(int[] order:orders) {
            if(order[2]==0){
                while(order[1]>0){
                    if(sell.isEmpty()||sell.peek().price>order[0]){
                        break;
                    }
                    Order s=sell.poll();
                    int min=Math.min(order[1],s.time);
                    s.time -= min;
                    order[1] -= min;
                    if(s.time>0)
                        sell.add(s);
                }

                if(order[1]>0)
                    buy.add(new Order(order[0],order[1]));
            }

            else {
                while(order[1]>0){
                    if(buy.isEmpty()||buy.peek().price<order[0]){
                        break;
                    }
                    Order b=buy.poll();
                    int min=Math.min(order[1],b.time);
                    b.time -= min;
                    order[1] -= min;
                    if(b.time>0)
                        buy.add(b);
                }

                if(order[1]>0)
                    sell.add(new Order(order[0],order[1]));
            }
        }

        int result=0;
        int mod=1000000007;
        for(Order o:sell) {
            result += o.time;
            result%=mod;
        }
        for(Order o:buy) {
            result += o.time;
            result %=mod;
        }
        return result;
    }


}
