package interview;

public class Problem5_4 {
    /*Description
    * 下一个数。给定一个正整数，找出与其二进制表达式中1的个数相同且大小最接近的那两个数（一个略大，一个略小）。
    * */

    public int[] findClosedNumbers(int num) {
        return new int[]{getMax(num),getMin(num)};
    }

    private int getMax(int num){
        int pre1=0;
        for(int i=0;i<31;i++){
            if((num>>i&1)==1){
                pre1++;
            }else{
                if(pre1!=0){

                    System.out.println(num);
                    //第i位变为1
                    num|=(1<<i);
                    num=(num>>i)<<i;
                    //第pre1位变为0；
                    num+=(1<<(pre1-1))-1;
                    return num;
                }
            }
        }
        return -1;
    }

    private int getMin(int num){
        int pre0=0;
        for(int i=0;i<31;i++){
            if((num>>i&1)==0){
                pre0++;
            }else{
                if(pre0!=0){
                    //第i位变为1
                    num=num>>(i+1)<<(i+1);
                    getformat2(num);
                    int pre1=i+1-pre0;
                    int add=(1<<pre1)-1;
                    getformat2(add);
                    add=add<<(pre0-1);
                    getformat2(add);
                    //第pre1位变为0；
                    num+=add;
                    return num;
                }
            }
        }
        return -1;
    }

    public static void getformat2(int max){
        StringBuilder sb=new StringBuilder();
        while(max>0){
            sb.append(max%2);
            max/=2;
        }
        System.out.println(sb.reverse());
    }

    public static void main(String[] args){
        String test="111000111000111";
        int num=0;
        int base=1;
        for(int j=test.length()-1;j>=0;j--){
            if(test.charAt(j)=='1'){
                num+=base;
            }
            base*=2;
        }
        int max=new Problem5_4().getMin(num);
        getformat2(max);
        System.out.println(max);
    }
}
