package linkedlist;

import linkedlist.MyLinkedList.MyNode;

//TODO: Solve similiar tasks for practice: ReverseLinked List 2, Palindrome LinkedList, Reverse Nodes in Even Length Groups
// Maximum Twin Sum of a Linked List
public class ReverseLinkedList {
    public static void main(String[] args) {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.addElement(1);
        myLinkedList.addElement(2);
        myLinkedList.addElement(3);
        myLinkedList.addElement(4);
        myLinkedList.addElement(5);
        myLinkedList.addElement(6);
        MyNode<Integer> head = myLinkedList.getHead();
        myLinkedList.printElements();
        //reverseWithRecursionList(head);
        System.out.println();
        myLinkedList.reverse();
        myLinkedList.printElements();
    }

    //TODO: Write explanation about recursion and space complexity!!!
    // Space Complexity: O(n) since there are n stack spaces used
    private static MyNode<Integer> reverseWithRecursionList(MyNode<Integer> head) {
        if (null == head || null == head.next)
            return head;
        MyNode<Integer> newHead = reverseWithRecursionList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }


    // Space complexity of O(1)
    private static MyNode<Integer> reverseWithLoopList(MyNode<Integer> head) {
        MyNode<Integer> prevNode = null;
        while (null != head) {
            MyNode<Integer> nextNode = head.next;
            head.next = prevNode;
            prevNode = head;
            head = nextNode;
        }
        return prevNode;
    }
}
