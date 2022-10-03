package leetcode.leetcode22;

import java.util.*;

public class Leetcode2184 {

    Set<Integer> brick;
    List<Integer> list=new ArrayList<>();
    public int buildWall(int height, int width, int[] bricks) {
        this.brick=new HashSet<>();
        for(int brick:bricks)
            this.brick.add(brick);
        dfs(width,0,0);
//        for(int c:list){
//            System.out.println(Integer.toBinaryString(c));
//        }
//        System.out.println(list);

        if(list.size()==0)
            return 0;
        int[] count=new int[list.size()];
        List<List<Integer>> l=new ArrayList<>();
        for(int i=0;i<list.size();i++){
            List<Integer> curList=new ArrayList<>();
            for (int j=0;j<list.size();j++) {
                if ((list.get(i) & list.get(j)) == 0)
                    curList.add(j);
            }
            l.add(curList);
        }
        int mod=1000000007;
        long[] result=new long[count.length];
        Arrays.fill(result,1);

        for(int i=0;i<height-1;i++){
            long[] res=new long[result.length];
            for(int j=0;j<count.length;j++){
                for(int next:l.get(j)){
                    res[next] = (res[next]+result[j])%mod;
                }
            }
            result=res;
        }

        long r=0;
        for(long c:result){
            r=(r+c)%mod;
        }

        return (int) r;
    }

    private void dfs(int width,int curWidth,int cur){
        if(curWidth==width){
            list.add(cur);
            return;
        }

        for(int i=curWidth+1;i<=width;i++){
            if(this.brick.contains(i-curWidth)){
                int curr=cur;
                if(i<width){
                    curr+=(2<<i);
                }
                dfs(width,i,curr);
            }
        }
    }

}
