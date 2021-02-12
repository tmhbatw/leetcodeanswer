package leetcode6;

public class Leetcode537 {
    /*Description
    * 给定两个表示复数的字符串。
    * 返回表示它们乘积的字符串。注意，根据定义 i方 = -1 。
    * */

    public String complexNumberMultiply(String a, String b) {
        if(a==null||a.length()==0)
            return b;
        if(b==null||b.length()==0)
            return a;
        String[] aa=a.split("\\+");
        String[] bb=b.split("\\+");
        int[] co1=getCoefficient(aa),co2=getCoefficient(bb);
        return getRes(co1,co2);
    }

    private String getRes(int[] co1,int[] co2){
        int a=co1[0]*co2[0]-co1[1]*co2[1];
        int b=co1[0]*co2[1]+co1[1]*co2[0];
        return a+"+"+b+"i";
    }

    private int[] getCoefficient(String[] aa){
        int[] a=new int[2];
        if(aa.length==2){
            a[0]=Integer.parseInt(aa[0]);
            a[1]=Integer.parseInt(aa[1].substring(0,aa[1].length()-1));
        }else{
            if(aa[0].charAt(aa[0].length()-1)=='i'){
                a[1]=Integer.parseInt(aa[0].substring(0,aa[0].length()-1));
            }else
                a[0]=Integer.parseInt(aa[0]);
        }
        return a;
    }
}
