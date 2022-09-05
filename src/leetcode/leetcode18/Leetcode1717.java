package leetcode.leetcode18;

public class Leetcode1717 {

    public int maximumGain(String s, int x, int y) {
        char a='a';
        char b='b';
        if(x<y){
            int temp=x;
            x=y;
            y=temp;
            a='b';
            b='a';
        }

        int result = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==a||s.charAt(i)==b){
                int cura=0;
                int curb=0;
                while(i<s.length()&&(s.charAt(i)==a||s.charAt(i)==b)){
                    if(s.charAt(i)==a) {
                        cura++;
                    }
                    else {
                        curb++;
                        if(cura>0){
                            cura--;
                            curb--;
                            result+=x;
                        }
                    }
                    i++;
                }
                i--;
                result+=Math.min(cura,curb)*y;
            }
        }

        return result;
    }


}
