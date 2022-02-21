package leetcode.leetcode22;

public class Leetcode2182 {

    public String repeatLimitedString(String s, int repeatLimit) {
        int[] num=new int[26];
        for(char c:s.toCharArray()){
            num[c-'a']++;
        }

        char pre='\u0000';
        StringBuilder sb=new StringBuilder();
        while(true){
            boolean flag=true;
            for(int i=25;i>=0;i--){
                if(num[i]>0){
                    if((char)(i+'a')!=pre) {
                        int time = Math.min(num[i], repeatLimit);
                        num[i] -= time;
                        sb.append(getS((char) (i + 'a'), time));
                        pre = (char) (i + 'a');
                        flag = false;
                        break;
                    }
                    else{
                        boolean ff=false;
                        for(int j=i-1;j>=0;j--){
                            if(num[j]>0){
                                num[j]--;
                                sb.append((char)(j+'a'));
                                pre=(char)(j+'a');
                                flag=false;
                                ff=true;
                                break;
                            }
                        }
                        if(ff){
                            break;
                        }
                    }
                }
            }
            if(flag)
                return sb.toString();
        }
    }


    public StringBuilder getS(char c,int time){
        StringBuilder sb=new StringBuilder();
        while(time-->0){
            sb.append(c);
        }

        return sb;
    }
}
