package leetcode.leetcode22;

public class Leetcode2156 {

    //从尾部开始遍历
    public String subStrHash(String s, int power, int modulo, int k, int hashValue) {
        long cur=0;

        long realPower=1;
        int result=s.length()-k;
        for(int i=s.length()-k;i<s.length();i++){
            cur+=realPower*(s.charAt(i)-'a'+1);
            cur%=modulo;

            if(i==s.length()-1)
                continue;
            realPower=(realPower*power)%modulo;
        }

        for(int i=s.length()-1;i>=k;i--){
            long remove=realPower*(s.charAt(i)-'a'+1)%modulo;
            cur -= remove;
            if(cur<0)
                cur+=modulo;

            cur=(cur*power+s.charAt(i-k)-'a'+1)%modulo;
            if(cur==hashValue){
                result=i-k;
            }
        }
        return s.substring(result,result+k);
    }

    public static void main(String[] args){
        long a= 1;
        int b= 1;
        System.out.println(a==b);
    }
}
