package leetcode.leetcode18;

import javax.swing.plaf.metal.MetalIconFactory;

public class Leetcode1737 {

    public int minCharacters(String a, String b) {
        int time1=getTime(a,b);
        int time2=getTime1(a,b);
        int time3=getTime1(b,a);

        return Math.min(time1,Math.min(time2,time3));
    }

    private int getTime(String a,String b){
        int[] time=new int[26];
        for(char c:a.toCharArray())
            time[c-'a']++;
        for(char c:b.toCharArray())
            time[c-'a']++;

        int max=0;
        for(int num:time)
            max=Math.max(num,max);
        return a.length()+b.length()-max;
    }

    private int getTime1(String a,String b){
        int[] time1=new int[26];
        int[] time2=new int[26];
        for(int i=0;i<a.length();i++){
            time1[a.charAt(i)-'a']++;
        }
        for(int i=0;i<b.length();i++){
            time2[b.charAt(i)-'a']++;
        }

        int result=Integer.MAX_VALUE;
        for(int i=0;i<25;i++){
            int cur=0;
            for(int j=i+1;j<26;j++)
                cur+=time1[j];
            for(int j=0;j<=i;j++)
                cur+=time2[j];
            result=Math.min(result,cur);


        }
        return result;
    }
}
