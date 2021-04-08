package leetcode.leetcode1;

public class Leetcode60 {
    /*Description
    * 给出集合[1,2,3,...,n]，其所有元素共有n! 种排列。
    * 按大小顺序列出所有排列情况，并一一标记，当n = 3 时, 所有排列如下：
    * "123"
    * "132"
    * "213"
    * "231"
    * "312"
    * "321"
    * 给定n 和k，返回第k个排列。
    * */

    public String getPermutation(int n, int k) {
        int[] result=new int[n];
        boolean[] reached=new boolean[n+1];
        int number=1;
        for(int i=1;i<n;i++)
            number*=i;
        for(int i=0;i<n;i++){
            int time=(k-1)/number;
            for(int j=1;j<=n;j++){
                if(!reached[j]){
                    if(time==0){
                        result[i]=j;
                        reached[j]=true;
                        break;
                    }else{
                        time--;
                    }
                }
            }
            k-=(k-1)/number*number;
            number/=(n-i-1)==0?1:(n-i-1);
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++)
            sb.append(result[i]);
        return sb.toString();
    }

    public static void main(String[] args){
        System.out.println(new Leetcode60().getPermutation(9,9876));
    }
}
