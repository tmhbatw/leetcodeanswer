package leetcode.leetcode22;

public class leetcode2103 {

    public int countPoints(String rings) {
        int[] num=new int[10];
        for(int i=0;i<rings.length();i+=2){
            char color=rings.charAt(i);
            int index=rings.charAt(i+1)-'0';

            num[index]|=(getVal(color));
        }

        int result=0;
        for(int n:num){
            if(n==7)
                result++;
        }
        return result;
    }

    private int getVal(char cur){
        switch (cur){
            case 'R':
                return 1;
            case 'G':
                return 2;
            default:
                return 4;
        }
    }

    public static void main(String[] args){
        int num=0;
        System.out.println(num|4|2|1|1);
    }
}
