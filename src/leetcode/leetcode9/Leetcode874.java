package leetcode.leetcode9;

import java.util.*;

public class Leetcode874 {


    int result=0;
    int x=0;
    int y=0;
    int direct = 10000; //mod 4 = 0（北），1（东），2（南），3（西）
    Map<Integer, List<Integer>> xMap;
    Map<Integer, List<Integer>> yMap;
    public int robotSim(int[] commands, int[][] obstacles) {
        xMap = new HashMap<>();
        yMap = new HashMap<>();
        for (int[] obstacle : obstacles) {
            if(obstacle[0]==0&&obstacle[1]==0)
                continue;
            xMap.putIfAbsent(obstacle[0],new ArrayList<>());
            yMap.putIfAbsent(obstacle[1],new ArrayList<>());

            xMap.get(obstacle[0]).add(obstacle[1]);
            yMap.get(obstacle[1]).add(obstacle[0]);
        }

        for(int key:xMap.keySet()){
            Collections.sort(xMap.get(key));
        }
        for(int key:yMap.keySet()) {
            Collections.sort(yMap.get(key));
        }

        for(int command :commands) {
            if(command==-2)
                direct--;
            if(command==-1)
                direct++;
            if(command>=1&&command<=9){
                move(command);
                result=Math.max(result,x*x+y*y);
            }
        }
        return result;
    }

    private void move(int move){
        switch (direct%4) {
            case 0:
                y+=getRealMove(move, false, true);
                break;
            case 1:
                x+=getRealMove(move, true, true);
                break;
            case 2:
                y-=getRealMove(move, false, false);
                break;
            default:
                x-=getRealMove(move,true,false);
        }
    }

    private int getRealMove(int move,boolean x,boolean add){
        List<Integer> list=x?yMap.get(this.y):xMap.get(this.x);
        int cur = x?this.x:this.y;
        if(list==null)
            return move;

        if(add){
            if(list.get(list.size()-1)<cur)
                return move;
            int l=0,r=list.size()-1;
            while(l<r){
                int mid=(l+r)/2;
                if(list.get(mid)>cur){
                    r=mid;
                }else{
                    l=mid+1;
                }
            }
            return Math.min(move,list.get(l)-cur-1);

        }else{
            if(list.get(0)>cur)
                return move;
            int l=0,r=list.size()-1;
            while(l<r){
                int mid=(l+r+1)/2;
                if(list.get(mid)<cur)
                    l=mid;
                else
                    r=mid-1;
            }
            return Math.min(move,cur-list.get(l)-1);
        }
    }



}
