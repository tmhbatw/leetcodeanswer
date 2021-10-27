package leetcode.leetcode5;

public class Leetcode423 {


    //0 zero
    //1 one
    //2 two
    //3 three
    //4 four
    //5 five
    //6 six
    //7 seven
    //8 eight
    //9 nine
    public String originalDigits(String s) {
        int[] num=new int[26];
        for(int i=0;i<s.length();i++){
            num[s.charAt(i)-'a']++;
        }

        int[] res=new int[10];
        res[0]=num['z'-'a'];
        res[2]=num['w'-'a'];
        res[4]=num['u'-'a'];
        res[6]=num['x'-'a'];
        res[8]=num['g'-'a'];
        res[3]=num['h'-'a']-res[8];
        res[5]=num['f'-'a']-res[4];
        res[7]=num['s'-'a']-res[6];
        res[9]=num['i'-'a']-res[5]-res[6]-res[8];
        res[1]=num['n'-'a']-res[7]-res[9]*2;

        StringBuilder sb=new StringBuilder();
        for(int i=0;i<=9;i++){
            for(int j=0;j<res[i];j++)
                sb.append(i);
        }

        return sb.toString();
    }
}
