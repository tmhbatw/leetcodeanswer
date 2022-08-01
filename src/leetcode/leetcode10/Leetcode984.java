package leetcode.leetcode10;

public class Leetcode984 {
    public String strWithout3a3b(int a, int b) {
        if(a==b)
            return getStr(a,'a');
        if(a>b){
            return strWithout3a3b(a,b,'a');
        }
        return strWithout3a3b(a,b,'b');
    }

    private String strWithout3a3b(int a,int b,char cur){
        if(a==b)
            return getStr(a,cur);
        if(cur=='a'){
            if(a==1||a<b)
                return "A"+strWithout3a3b(a-1,b,'b');
            else
                return "AA"+strWithout3a3b(a-2,b,'b');
        }
        else{
            if(b==1||b<a)
                return "B"+strWithout3a3b(a,b-1,'a');
            else
                return "BB"+strWithout3a3b(a,b-2,'a');
        }
    }

    public String getStr(int a,char cur){
        StringBuilder res=new StringBuilder();
        for(int i=0;i<a;i++){
            if(cur=='a')
                res.append("ab");
            else
                res.append("ba");
        }
        return res.toString();
    }
}
