package leetcode.leetcode17;

import java.util.Stack;

public class Leetcode1628 {

    abstract class Node {
        public abstract int evaluate();
        // define your fields here
    };

    class MyNode extends Node{
        String val;
        MyNode left=null;
        MyNode right=null;
        public MyNode(String val){
            this.val=val;
        }
        @Override
        public int evaluate() {
            switch (val) {
                case "+":
                    return left.evaluate() + right.evaluate();
                case "-":
                    return left.evaluate() - right.evaluate();
                case "/":
                    return left.evaluate() / right.evaluate();
                case "*":
                    return left.evaluate() * right.evaluate();
                default:
                    return Integer.parseInt(val);
            }
        }
    }

    class TreeBuilder {
        Node buildTree(String[] postfix) {
            Stack<MyNode> s=new Stack<>();
            for(String cur:postfix){
                switch (cur){
                    case "+": case "-": case "*": case "/":
                        MyNode right=s.pop();
                        MyNode left=s.pop();
                        MyNode node=new MyNode(cur);
                        node.left=left;
                        node.right=right;
                        s.add(node);
                        break;
                    default:
                        MyNode n=new MyNode(cur);
                        s.add(n);
                }
            }
            return s.pop();
        }
    };

}
