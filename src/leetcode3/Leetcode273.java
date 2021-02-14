package leetcode3;

public class Leetcode273 {
    /*Description
    * 将非负整数 num 转换为其对应的英文表示。
    * */

    String[] res=new String[]{"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven",
                    "Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    public String numberToWords(int num) {
        if(num==0)
            return "Zero";
        String result= numChange(num);
        int length=result.length();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<length;i++){
            if(result.charAt(i)==' '){
                while(i<length-1&&result.charAt(i+1)==' ')
                    i++;
                if(i!=length-1)
                sb.append(' ');
            }else
                sb.append(result.charAt(i));
        }
        return sb.toString();
    }

    private String numChange(int num){
        if(num>=1000000000)
            return numChange(num/1000000000)+" Billion "+numChange(num%1000000000);
        if(num>=1000000)
            return numChange(num/1000000)+" Million "+numChange(num%1000000);
        if(num>=1000)
            return numChange(num/1000)+" Thousand "+numChange(num%1000);
        if(num>=100)
            return numChange(num/100)+" Hundred "+numChange(num%100);
        if(num>=90)
            return "Ninety "+numChange(num-90);
        if(num>=80)
            return "Eighty "+numChange(num-80);
        if(num>=70)
            return "Seventy "+numChange(num-70);
        if(num>=60)
            return "Sixty "+numChange(num-60);
        if(num>=50)
            return "Fifty "+numChange(num-50);
        if(num>=40)
            return "Forty "+numChange(num-40);
        if(num>=30)
            return "Thirty "+numChange(num-30);
        if(num>=20)
            return "Twenty "+numChange(num-20);
        return res[num];
    }

}
