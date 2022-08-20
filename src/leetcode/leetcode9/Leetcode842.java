package leetcode.leetcode9;

import java.util.ArrayList;
import java.util.List;

public class Leetcode842 {

    public List<Integer> splitIntoFibonacci(String num) {
        List<Integer> result=new ArrayList<>();
        for(int i=1;i<Math.min(num.length()-2,11);i++){
            for(int j=i+1;j<Math.min(num.length()-1,i+11);j++){
                if(match(num,i,j)!=null){
                    return match(num,i,j);
                }
            }
        }
        return result;
    }

    private List<Integer> match(String num,int i,int j){
        List<Integer> result=new ArrayList<>();
        if(num.charAt(0)=='0'&&i>1)
            return null;
        if(num.charAt(i)=='0'&&j-i>1)
            return null;

        long first=Long.parseLong(num.substring(0,i));
        if(first>Integer.MAX_VALUE)
            return null;
        long second=Long.parseLong(num.substring(i,j));
        if(second>Integer.MAX_VALUE)
            return null;
        result.add((int) first);
        result.add((int) second);

        while(j<num.length()){
            long next=first+second;
            int length=(next+"").length();

            if(next>Integer.MAX_VALUE||num.length()-j<length||Long.parseLong(num.substring(j,j+length))!=next)
                return null;
            first=second;
            second=next;
            j+=length;
            result.add((int) next);
        }

        //System.out.println(i+" "+j+" "+result);

        return result;
    }

    public static void main(String[] args){
        String num="01123581321345589";
        System.out.println(new Leetcode842().splitIntoFibonacci(num));
    }
}
