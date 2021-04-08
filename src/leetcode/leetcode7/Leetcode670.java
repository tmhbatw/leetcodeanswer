package leetcode.leetcode7;

import java.util.ArrayList;
import java.util.List;

public class Leetcode670 {
    /*Description
    * 给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
    * */

    public int maximumSwap(int num) {
        List<Point> list=new ArrayList<>();
        String n=num+"";
        for(int i=0;i<n.length();i++){
            char c=n.charAt(i);
            while(!list.isEmpty()&&list.get(list.size()-1).val<c)
                list.remove(list.size()-1);
            list.add(new Point(c,i));
        }
        if(list.size()==n.length())
            return num;
        int index=0;
        for(;index<list.size();index++){
            if(list.get(index).index!=index)
                break;
        }
        int val=list.get(index).val;
        int i=index;
        while(index<list.size()-1&&val==list.get(index+1).val)
            index++;
        StringBuilder res=new StringBuilder();
        res.append(n);
        res.setCharAt(i,(char)(val));
        res.setCharAt(list.get(index).index,n.charAt(i));
        return Integer.parseInt(res.toString());
    }

    class Point{
        int val;
        int index;
        Point(int val,int index){
            this.val=val;
            this.index=index;
        }
    }
}
