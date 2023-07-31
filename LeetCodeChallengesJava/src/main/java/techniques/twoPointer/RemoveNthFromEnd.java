package techniques.twoPointer;

import linkedlist.MyLinkedList;
import linkedlist.MyLinkedList.MyNode;


/**
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 *
 */
public class RemoveNthFromEnd {
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.addElement(1);
        list.addElement(2);
        list.addElement(3);
        list.addElement(4);
        list.addElement(5);

        int n = 2;

        removeNthFromEnd(list.getHead(), n);
        list.printElements();
    }

    //Idea: n-th of the end == list.length - n of the beginning
    public static MyNode<Integer> removeNthFromEnd(MyNode<Integer> head, int n) {
        MyNode<Integer> firstPointer = head;
        MyNode<Integer> secondPointer = head;

        int counter = 0;
        while(null != secondPointer && counter < n) {
            secondPointer = secondPointer.getNext();
            counter++;
        }

        if (null == secondPointer) {
            head = head.getNext();
            return head;
        }

        while(null != secondPointer.getNext()) {
            firstPointer = firstPointer.getNext();
            secondPointer = secondPointer.getNext();
        }

        firstPointer.setNext(firstPointer.getNext().getNext());
        return head;
    }

}
