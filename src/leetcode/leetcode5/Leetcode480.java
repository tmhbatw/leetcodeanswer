package leetcode.leetcode5;

import java.util.PriorityQueue;

public class Leetcode480 {

    public double[] medianSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> q1=new PriorityQueue<>((o1,o2)->{return o1<o2?-1:1;});
        PriorityQueue<Integer> q2=new PriorityQueue<>((o1,o2)->{return o2<o1?-1:1;});

        double[] res=new double[nums.length-k+1];
        int index=0;

        for(int i=0;i<nums.length;i++){
            insert(nums[i],q1,q2);
            if(i<k-1){
                continue;
            }
            double cur=q2.peek();
            if(k%2==0)
                cur=(cur+q1.peek())/2;
            res[index++]=cur;
            delete(nums[i-k+1],q1,q2);
        }
        return res;
    }

    private void delete(int num,PriorityQueue<Integer> q1,PriorityQueue<Integer> q2){
        if(!q1.remove(num)) {
            q2.remove(num);
        }
        if(q1.size()>q2.size()){
            q2.add(q1.poll());
        }
    }

    private void insert(int num,PriorityQueue<Integer> q1,PriorityQueue<Integer> q2){
        if(!q1.isEmpty()&&q1.peek()<num){
            q1.add(num);
            num=q1.poll();
        }
        q2.add(num);
        if(q2.size()-q1.size()>=2)
            q1.add(q2.poll());
    }
}
