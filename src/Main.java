import java.util.*;
public class Main {


    static final String wrong1="invalid expression";
    static final String wrong2="division by zero";

    static boolean flag1=false;
    static boolean flag2=false;

    public static void main(String[] args){
       //String s=new Scanner(System.in).nextLine();
        String s="(+ (* 1 2 3) (/ 6 2) (- 1 4))";
       if(!validChar(s)) {
           System.out.println(wrong1);
           return ;
       }
       List<String> ss=getList(s);
       //System.out.println(ss);
       int res=getRes(ss,0,ss.size()-1);
       if(flag1)
           System.out.println(wrong1);
       else if(flag2)
           System.out.println(wrong2);
       else
           System.out.println(res);
    }

    //首先应该脱去括号
    public static int getRes(List<String> s,int start,int end){
        if(!s.get(start).equals("(")||!s.get(end).equals(")")||end-start<=1){
            flag1=true;
            return 0;
        }
        String operand=s.get(start+1);
        if(operand.length()!=1){
            flag1=true;
            return 0;
        }
        char o=operand.charAt(0);
        if(o!='*'&&o!='+'&&o!='-'&&o!='/'){
            flag1=true;
            return 0;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=start+2;i<end;i++){
            String cur=s.get(i);
            if(cur.equals("(")){
                int nextStart=i;
                int count=1;
                while(i<end-1&&count!=0){
                    i++;
                    if(s.get(i).equals("("))
                        count++;
                    if(s.get(i).equals(")"))
                        count--;
                }
                if(count!=0){
                    flag1=true;
                    return 0;
                }else{
                    q.add(getRes(s,nextStart,i));
                }
            }else if(cur.equals(")")){
                flag1=true;
                return 0;
            }else{
                q.add(Integer.parseInt(cur));
            }
        }
        if(q.isEmpty()){
            flag1=true;
            return 0;
        }
        //System.out.println(q);
        int res=0;
        switch (o){
            case '+':
                for(int cur:q){
                    res+=cur;
                }
                break;
            case '*':
                res=1;
                for(int cur:q){
                    res*=cur;
                }
                break;
            case '-':
                if(q.size()!=2){
                    flag1=true;
                    return 0;
                }
                res=q.poll()-q.poll();
                break;
            case '/':
                if(q.size()!=2){
                    flag1=true;
                    return 0;
                }
                int a=q.poll();
                int b=q.poll();
                if(b==0){
                    flag2=true;
                    return 0;
                }
                res=a/b;
        }
        return res;
    }

    private static boolean validChar(String cur){
        for(int i=0;i<cur.length();i++){
            char c=cur.charAt(i);
            if(c<='9'&&c>='0'||c=='('||c==')'||c=='*'||c=='+'||c=='-'||c=='/'||c==' ')
                continue;
            return false;
        }
        return true;
    }

    public static List<String> getList(String s){
        List<String> list=new ArrayList<>();
        for(int i=0;i<s.length();i++){
            char cur=s.charAt(i);
            if(cur==' ')
                continue;
            if(cur=='('||cur==')'||cur=='+'||cur=='-'||cur=='*'||cur=='/') {
                list.add(cur + "");
                continue;
            }
            long c=cur-'0';
            while(i<s.length()-1&&s.charAt(i+1)<='9'&&s.charAt(i+1)>='0')
                c=c*10+s.charAt(++i)-'0';
            if(c<Integer.MIN_VALUE||c>=Integer.MAX_VALUE){
                flag1=true;
            }
            list.add(c+"");
        }
        return list;
    }
}