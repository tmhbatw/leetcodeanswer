package leetcode.leetcode15;

public class Leetcode1432 {

    public int maxDiff(int num) {
        System.out.println(getMax(num));
        System.out.println(getMin(num));
        return getMax(num)-getMin(num);
    }

    private int getMax(int num){
        char[] c=(num+"").toCharArray();
        for(int i=0;i<c.length;i++){
            if(c[i]!='9'){
                for(int j=c.length-1;j>=i;j--){
                    if(c[j]==c[i])
                        c[j]='9';
                }
                break;
            }
        }

        return Integer.parseInt(new String(c));
    }

    private int getMin(int num){
        char[] c=(num+"").toCharArray();
        for(int i=0;i<c.length;i++){
            if(i==0&&c[i]!='1'){
                for(int j=c.length-1;j>=i;j--){
                    if(c[j]==c[i]){
                        c[j]='1';
                    }
                }
                break;
            }
            if(i>=1&&c[i]>='2'){
                for(int j=c.length-1;j>=i;j--){
                    if(c[j]==c[i]){
                        c[j]='0';
                    }
                }
                break;
            }
        }
        return Integer.parseInt(new String(c));
    }


    public static void main(String[] args){
        int t=123456;
        System.out.println(new Leetcode1432().maxDiff(t));
    }
}
