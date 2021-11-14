package leetcode.leetcode4;

import java.util.ArrayList;
import java.util.List;

public class Leetcode315 {

    class Node{
        int num;
        int index;
        public Node(int num,int index){
            this.num=num;
            this.index=index;
        }

        public String toString(){
            return this.num+" "+this.index;
        }
    }

    int[] res;
    public List<Integer> countSmaller(int[] nums) {
        Node[] node=new Node[nums.length];
        for(int i=0;i<nums.length;i++){
            node[i]=new Node(nums[i],i);
        }
        res=new int[nums.length];
        sort(node,0,node.length-1);
        List<Integer> result=new ArrayList<>();
        for(int num:res)
            result.add(num);
        return result;
    }

    private void sort(Node[] node,int l, int r){
        if(l==r)
            return;
        int mid=(l+r)/2;
        sort(node,l,mid);
        sort(node,mid+1,r);

        int i1=l,i2=mid+1;
        List<Node> list=new ArrayList<>();
        while(i1<=mid&&i2<=r){
            int val1=i1>mid?Integer.MAX_VALUE:node[i1].num;
            int val2=i2>r?Integer.MAX_VALUE:node[i2].num;
            if(val1<=val2){
                res[node[i1].index]+=i2-mid-1;
                list.add(node[i1++]);
            }else{
                list.add(node[i2++]);
            }
        }
        System.out.println(list+" "+l+" "+r);
        for(int i=l;i<=r;i++)
            node[i]=list.get(i-l);
    }
}
