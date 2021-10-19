package forOffer2;

import java.util.Stack;

public class ForOffer36 {

    public int evalRPN(String[] tokens) {
        Stack<Integer> s=new Stack<>();
        for(String cur:tokens){
            switch (cur){
                case "+":
                    int val2=s.pop(),val1=s.pop();
                    s.add(val1+val2);
                    break;
                case "-":
                    val2=s.pop();
                    val1=s.pop();
                    s.add(val1-val2);
                    break;
                case "*":
                    val2=s.pop();
                    val1=s.pop();
                    s.add(val1*val2);
                    break;
                case "/":
                    val2=s.pop();
                    val1=s.pop();
                    s.add(val1/val2);
                    break;
                default:
                    s.add(Integer.parseInt(cur));
            }
        }
        return s.pop();
    }
}
