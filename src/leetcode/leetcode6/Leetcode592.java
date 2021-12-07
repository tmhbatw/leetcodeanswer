package leetcode.leetcode6;

public class Leetcode592 {


    class Number{
        int a,b;
        private int getGcd(int a,int b){
            if(a%b==0)
                return b;
            return getGcd(b,a%b);
        }

        public Number(int a,int b){
            this.a=a;
            this.b=b;
        }

        public void add(Number a){
            int newB=this.b*a.b;
            int newA=this.a*a.b+a.a*this.b;

            if(newA==0){
                this.a=0;
                this.b=1;
            }
            if(newA>0){
                int gcd=getGcd(Math.max(newA,newB),Math.min(newA,newB));
                this.a=newA/gcd;
                this.b=newB/gcd;
            }
            if(newA<0){
                int gcd=getGcd(Math.max(-newA,newB),Math.min(-newA,newB));
                this.a=newA/gcd;
                this.b=newB/gcd;
            }
        }
    }
    public String fractionAddition(String expression) {
        Number cur=new Number(0,1);
        int length=expression.length();
        boolean positive=true;
        for(int i=0;i<expression.length();i++){
            if(expression.charAt(i)=='-'){
                positive=false;
                continue;
            }
            if(expression.charAt(i)=='+'){
                positive=true;
                continue;
            }
            int a=expression.charAt(i)-'0';
            while(i<length-1&&expression.charAt(i+1)!='/'){
                a=a*10+expression.charAt(++i)-'0';
            }
            i=i+2;
            int b=0;
            while(i<length&&expression.charAt(i)<='9'&&expression.charAt(i)>='0'){
                b=b*10+expression.charAt(i++)-'0';
            }
            i--;
            cur.add(new Number(positive?a:-a,b));
            System.out.println(a+" "+b);
        }
        return cur.a+"/"+cur.b;
    }
}
