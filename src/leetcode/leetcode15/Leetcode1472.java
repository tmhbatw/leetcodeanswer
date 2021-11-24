package leetcode.leetcode15;

import java.util.Stack;

public class Leetcode1472 {

    class BrowserHistory {
        Stack<String> s1;
        Stack<String> s2;

        public BrowserHistory(String homepage) {
            this.s1=new Stack<>();
            s1.add(homepage);
            this.s2=new Stack<>();
        }

        public void visit(String url) {
            s1.add(url);
            s2=new Stack<>();
        }

        public String back(int steps) {
            while(s1.size()>1&&steps-->0){
                s2.add(s1.pop());
            }
            return s1.peek();
        }

        public String forward(int steps) {
            while(!s2.isEmpty()&&steps-->0){
                s1.add(s2.pop());
            }
            return s1.peek();
        }
    }

}
