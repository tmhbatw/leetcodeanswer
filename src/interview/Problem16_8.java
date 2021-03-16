package interview;

public class Problem16_8 {
    /*Description
    * 给定一个整数，打印该整数的英文描述。
    * */

    int[] num1=new int[]{1000000000,1000000,1000,100,90,80,70,60,50,40,30,20,19,18,17,16,15,14,13,12,11,10
        ,9,8,7,6,5,4,3,2,1};
    String[] english1=new String[]{"Billion","Million","Thousand","Hundred","Ninety","Eighty","Seventy","Sixty","Fifty",
        "Forty","Thirty","Twenty","Nineteen","Eighteen","Seventeen","Sixteen","Fifteen","Fourteen","Thirteen",
        "Twelve","Eleven","Ten","Nine","Eight","Seven","Six","Five","Four","Three","Two","One"};
    public String numberToWords(int num) {
        if(num==0)
            return "zero";
        return transform(num);
    }

    private String transform(int num){
        for(int i=0;i<4;i++){
            if(num>=num1[i]){
                if(num%num1[i]==0){
                    return transform(num/num1[i])+" "+english1[i];
                }else{
                    return transform(num/num1[i])+" "+english1[i]+" "+transform(num%num1[i]);
                }
            }
        }
        for(int i=4;i<num1.length;i++){
            if(num==num1[i])
                return english1[i];
            if(num>num1[i])
                return english1[i]+" "+transform(num-num1[i]);
        }
        return "";
    }

}
