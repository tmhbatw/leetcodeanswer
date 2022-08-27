package lcp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lcp46 {

    public int[] volunteerDeployment(int[] finalCnt, long totalNum, int[][] edges, int[][] plans) {
        long[] res=new long[finalCnt.length+1];
        long[] x = new long[res.length];
        for(int i=1;i<res.length;i++){
            res[i]=finalCnt[i-1];
        }
        x[0]=1;

        List<List<Integer>> l=new ArrayList<>();
        for(int i=0;i<res.length;i++)
            l.add(new ArrayList<>());
        for(int[] e:edges){
            l.get(e[0]).add(e[1]);
            l.get(e[1]).add(e[0]);
        }

        for(int j=plans.length-1;j>=0;j--){
            int idx=plans[j][1];
            switch (plans[j][0]){
                case 1:
                    res[idx]*=2;
                    x[idx]*=2;
                    break;
                case 2:
                    for(int n:l.get(idx)){
                        res[n]-=res[idx];
                        x[n]-=x[idx];
                    }
                    break;
                case 3:
                    for(int n:l.get(idx)){
                        res[n]+=res[idx];
                        x[n]+=x[idx];
                    }
            }
        }

        long sum = Arrays.stream(res).sum();
        long sumX=Arrays.stream(x).sum();

        long xx=(totalNum-sum)/sumX;
        System.out.println(xx);
        int[] result=new int[res.length];
        for(int i=0;i<result.length;i++){
            result[i] = (int) (res[i]+xx*x[i]);
        }

        return result;
    }

}
