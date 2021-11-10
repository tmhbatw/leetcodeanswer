package leetcode.leetcode8;

public class Leetcode738 {

    public int monotoneIncreasingDigits(int n) {
        char[] num=(n+"").toCharArray();
        for(int i=1;i<num.length;i++){
            if(num[i]<num[i-1]){
                decrease(num,i-1);
                break;
            }
        }
        return Integer.parseInt(new String(num));
    }

    private void decrease(char[] num,int index){
        while(index>=1&&num[index]==num[index-1])
            index--;
        num[index]-=1;
        for(int i=index+1;i<num.length;i++){
            num[i]='9';
        }
    }
}
