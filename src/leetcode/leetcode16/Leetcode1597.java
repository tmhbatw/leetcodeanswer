package leetcode.leetcode16;

import java.util.Stack;

public class Leetcode1597 {

    class Node {
        char val;
        Node left;
        Node right;

        Node() {
            this.val = ' ';
        }

        Node(char val) {
            this.val = val;
        }

        Node(char val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public Node expTree(String s) {
        Stack<Node> operator = new Stack<>();
        Stack<Node> number = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                operator.add(new Node('('));
                continue;
            }
            if (s.charAt(i) == ')') {
                while (operator.peek().val != '(') {
                    Node op = operator.pop();
                    Node numRight = number.pop();
                    Node numLeft = number.pop();
                    op.right = numRight;
                    op.left = numLeft;
                    number.add(op);
                }
                operator.pop();
                continue;
            }
            if (s.charAt(i) > '9' || s.charAt(i) < '0') {
                int level = getLevel(s.charAt(i));
                while (!operator.empty() && getLevel(operator.peek().val) >= level) {
                    Node op = operator.pop();
                    Node numRight = number.pop();
                    Node numLeft = number.pop();
                    op.right = numRight;
                    op.left = numLeft;
                    number.add(op);
                }
                operator.add(new Node(s.charAt(i)));
                continue;
            }
            number.add(new Node(s.charAt(i)));
        }

        while (!operator.empty()) {
            Node op = operator.pop();
            Node numRight = number.pop();
            Node numLeft = number.pop();
            op.right = numRight;
            op.left = numLeft;
            number.add(op);
        }
        return number.pop();
    }

    private int getLevel(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return 0;
        }
    }
}
