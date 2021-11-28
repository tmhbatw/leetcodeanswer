package leetcode.leetcode13;

import java.util.ArrayList;
import java.util.List;

public class Leetcode1291 {

    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> list=new ArrayList<>();

        int lowLength=(low+"").length();
        int highLength=(high+"").length();

        for(int l=lowLength;l<=highLength;l++){
            for(int start=1;start<=10-l;start++){
                int res=getRes(start,l);
                if(res<low)
                    continue;
                if(res>high)
                    break;
                list.add(res);
            }
        }
        return list;
    }


    private int getRes(int start, int length){
        if(start+length>10)
            return -1;
        int result=0;
        for(int i=0;i<length;i++){
            result=result*10+start;
            start++;
        }
        return result;
    }
}
