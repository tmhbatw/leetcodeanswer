package leetcode.leetcode18;

public class Leetcode1702 {

    public String maximumBinaryString(String binary) {
        int zeroTime = 0;
        int count =0;
        boolean flag=true;
        for(int i=0;i<binary.length();i++){
            if(flag){
                if(binary.charAt(i)=='1'){
                    count++;
                }else{
                    flag=false;
                }
            }

            if(binary.charAt(i)=='0')
                zeroTime++;
        }

        if(zeroTime<=1)
            return binary;
        return getS('1',count+zeroTime-1)+'0'+getS('1',binary.length()-zeroTime-count);
    }

    private String getS(char cur, int time){
        StringBuilder sb=new StringBuilder();
        while(time-->0)
            sb.append(cur);
        return sb.toString();
    }
}
