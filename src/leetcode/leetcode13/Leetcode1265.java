package leetcode.leetcode13;

public class Leetcode1265 {

      interface ImmutableListNode {
      public void printValue(); // print the value of this node.
      public ImmutableListNode getNext(); // return the next node.
     };
    public void printLinkedListInReverse(ImmutableListNode head) {
        if(head==null)
            return;
        printLinkedListInReverse(head.getNext());
        head.printValue();
    }
}
