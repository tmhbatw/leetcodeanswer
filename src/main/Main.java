package main;

import java.util.*;

public class Main{


    public int minimumRecolors(String blocks, int k) {
        int result=Integer.MAX_VALUE;
        int time=0;
        for(int i=0;i<blocks.length();i++){
            time+=blocks.charAt(i)=='B'?1:0;
            if(i<k-1){
                continue;
            }

            time+=blocks.charAt(i)=='B'?1:0;
            result=Math.min(result,k-time);
            time-=blocks.charAt(i-k+1)=='B'?1:0;
        }

        return result;
    }
}