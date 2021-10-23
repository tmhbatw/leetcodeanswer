package interview;

public class Problem17_06 {

    public int numberOf2sInRange(int n) {
        int result=0;
        result+=getFirst(n)+getLast(n);
        String num=n+"";
        //第1到i-1位的2
        int right=1;
        for(int i=0;i<num.length()-2;i++)
            right*=10;
        for(int i=1;i<num.length()-1;i++){
            int left=Integer.parseInt(num.substring(0,i));
            result+=left*right;
            if(num.charAt(i)=='2'){
                result+=Integer.parseInt(num.substring(i+1))+1;
            }
            if(num.charAt(i)>'2')
                result+=right;
            right/=10;
        }
        return result;
    }
    //获取末位的2
    private int getLast(int n){
        int num=n/10;
        if(n%10>=2)
            num++;
        return num;
    }
    //获取首位的2
    private int getFirst(int n){
        String num=n+"";
        if(num.length()<=1||num.charAt(0)=='1')
            return 0;
        if(num.charAt(0)=='2')
            return Integer.parseInt(num.substring(1))+1;
        int base=10;
        while(base*10<n)
            base*=10;
        return base;
    }
}
