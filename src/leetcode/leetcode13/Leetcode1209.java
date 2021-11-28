package leetcode.leetcode13;

import java.util.Stack;

public class Leetcode1209 {

    class Node{
        char c;
        int num;
        public Node(char c,int num){
            this.c=c;
            this.num=num;
        }
    }

    public String removeDuplicates(String s, int k) {
        Stack<Node> stack=new Stack<>();
        stack.add(new Node('\u0000',0));

        for(char c:s.toCharArray()){
            int time=1;
            if(stack.peek().c==c){
                time=stack.peek().num+1;
                if(time==k){
                    for(int j=0;j<k-1;j++)
                        stack.pop();
                    continue;
                }
            }
            stack.add(new Node(c,time));


        }

        StringBuilder sb=new StringBuilder();
        for(Node cur:stack) {
            sb.append(cur.c);
        }
        return sb.substring(1);

    }
}
