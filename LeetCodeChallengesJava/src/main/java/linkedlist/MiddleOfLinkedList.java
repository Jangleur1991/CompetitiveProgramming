package linkedlist;

import linkedlist.MyLinkedList.MyNode;

/**
 * Given the head of a singly linked list, return the middle node of the linked list.
 *
 * If there are two middle nodes, return the second middle node.
 */
public class MiddleOfLinkedList {
    public static void main(String[] args) {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.addElement(1);
        myLinkedList.addElement(2);
        myLinkedList.addElement(3);
        myLinkedList.addElement(4);
        myLinkedList.addElement(5);
        myLinkedList.addElement(6);
        MyNode<Integer> head = myLinkedList.getHead();
        System.out.println(middleNodeRec(head).toString());
    }

    private static MyNode<Integer> middleNodeRec(MyNode<Integer> head) {
        if (null == head || null == head.next)
            return head;
        return helper(head, head.next.next);
    }

    private static MyNode<Integer> helper(MyNode<Integer> slowPointer, MyNode<Integer> fastPointer) {
        return (null != fastPointer && null != fastPointer.next)
                ? helper(slowPointer.next, fastPointer.next.next)
                : slowPointer.next;
    }

    public static MyNode<Integer> middleNode(MyNode<Integer> head) {
        //Concept uses a special technique called "two pointers"
        MyNode<Integer> slowPointer = head;
        MyNode<Integer> fastPointer = head;
        while (null != fastPointer && null != fastPointer.next) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        return slowPointer;
    }
}
