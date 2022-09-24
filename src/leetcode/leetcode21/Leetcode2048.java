package leetcode.leetcode21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode2048 {

    int result = 0;
    int n;
    public int nextBeautifulNumber(int n) {
        if(n==1000000)
            return 1224444;
        int length=(n+"").length();
        result = getBig(length);
        this.n=n;

        List<Integer> l=new ArrayList<>();
        switch (length){
            case 1:
                add(l,1);
                assemble(l);
                break;
            case 2:
                add(l,2);
                assemble(l);
                break;
            case 3:
                add(l,3);
                assemble(l);
                l.clear();
                add(l,1);
                add(l,2);
                assemble(l);
                break;
            case 4:
                add(l,4);
                assemble(l);
                l.clear();
                add(l,1);
                add(l,3);
                assemble(l);
                break;
            case 5:
                add(l,5);
                assemble(l);
                l.clear();
                add(l,1);
                add(l,4);
                assemble(l);
                l.clear();
                add(l,2);
                add(l,3);
                assemble(l);
                break;
            case 6:
                add(l,6);
                assemble(l);
                l.clear();
                add(l,2);
                add(l,4);
                assemble(l);
                l.clear();
                add(l,1);
                add(l,5);
                assemble(l);
                l.clear();
                add(l,1);
                add(l,2);
                add(l,3);
                assemble(l);
                break;
        }

        return result;
    }

    private void add(List<Integer> list,int n ){
        for(int i=0;i<n;i++){
            list.add(n);
        }
    }

    private void assemble(List<Integer> list){
        int[] num=new int[list.size()];
        for(int i=0;i<list.size();i++){
            num[i]=list.get(i);
        }
        reverse(num,0);
    }

    //1,2,2,3,3,3
    private void reverse(int[] num,int i){
        if(i==num.length) {
            int cur=0;
            for(int n :num){
                cur= cur*10+n;
            }
            if(cur>n){
                result=Math.min(cur,result);
            }
            return;
        }
        reverse(num,i+1);
        for(int j=i+1;j<num.length;j++){
            if(num[i]==num[j])
                continue;
            int temp=num[i];
            num[i]=num[j];
            num[j]=temp;
            reverse(num,i+1);
            num[j]=num[i];
            num[i]=temp;
        }
    }


    private int getBig(int length){
        switch (length){
            case 1:
                return 22;
            case 2:
                return 122;
            case 3:
                return 1333;
            case 4:
                return 14444;
            case 5:
                return 122333;
            case 6:
                return 1224444;
        }
        return 1;
    }

    public static void main(String[] args){
        int test = 217998;
        System.out.println("res is :"+" "+new Leetcode2048().nextBeautifulNumber(test));
    }


}
