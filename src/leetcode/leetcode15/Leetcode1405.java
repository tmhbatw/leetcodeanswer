package leetcode.leetcode15;

import java.util.Arrays;

public class Leetcode1405 {

    char c1='a';
    char c2='b';
    char c3='c';
    int n1;
    int n2;
    int n3;

    public String longestDiverseString(int a, int b, int c) {
        this.n1=a;
        this.n2=b;
        this.n3=c;
        if(b>a&&b>c){
            c1='b';
            n1=b;
            c2=c>a?'c':'a';
            c3=c>a?'a':'c';
            n2=Math.max(a,c);
            n3=Math.min(a,c);
        }
        if(c>b&&c>a){
            c1='c';
            n1=c;
            c2=b>a?'b':'a';
            c3=b>a?'a':'b';
            n2=Math.max(a,b);
            n3=Math.min(a,b);
        }
        return getStr();
    }

    private String getStr(){
        StringBuilder sb=new StringBuilder();
        if(n1>=2*(n2+n3)){
            while(n2-->0){
                n1-=2;
                sb.append(c1).append(c1).append(c2);
            }
            while (n3-- > 0) {
                n1-=2;
                sb.append(c1).append(c1).append(c3);
            }
            for(int i=0;i<Math.min(n1,2);i++)
                sb.append(c1);
            return sb.toString();
        }else {
            while(n1>n2+n3){
                sb.append(c1).append(c1);
                n1-=2;
                if(n2>0){
                    n2--;
                    sb.append(c2);
                }else{
                    n3--;
                    sb.append(c3);
                }
            }
            char append=' ';
            while(n1!=0||n2!=0||n3!=0){
                append=getNewChar(append);
                if(append==c1)
                    n1--;
                if(append==c2)
                    n2--;
                if(append==c3)
                    n3--;
                sb.append(append);
            }
            return sb.toString();
        }
    }

    private char getNewChar(char pre){
        int[][] res=new int[][]{{n1,c1},{n2,c2},{n3,c3}};
        Arrays.sort(res,(o1,o2)-> o2[0]-o1[0]);

        for (int[] re : res) {
            if (pre == (char) re[1])
                continue;
            return (char) re[1];
        }

        return ' ';
    }


}
