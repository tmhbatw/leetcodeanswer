package leetcode.leetcode21;

public class Leetcode2042 {

    public boolean areNumbersAscending(String s) {
        int pre=-1;
        int length=s.length();

        for(int i=0;i<s.length();i++){
            char cur=s.charAt(i);
            if(cur<='9'&&cur>='0'){
                int num=cur-'0';
                while(i<length-1&&s.charAt(i+1)<='9'&&s.charAt(i+1)>='0'){
                    num=num*10+(s.charAt(++i)-'0');
                }

                if(num<=pre)
                    return false;
                pre=num;
            }
        }
        return true;
    }
}
