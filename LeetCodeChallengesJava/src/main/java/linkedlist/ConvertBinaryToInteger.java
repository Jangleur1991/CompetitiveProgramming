package linkedlist;

import linkedlist.MyLinkedList.MyNode;

/**
 * Given head which is a reference node to a singly-linked list. The value of each node in the linked list is either 0 or 1. The linked list holds the binary representation of a number.
 * <p>
 * Return the decimal value of the number in the linked list.
 */


public class ConvertBinaryToInteger {

    public static void main(String[] args) {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.addElement(1);
        myLinkedList.addElement(0);
        myLinkedList.addElement(1);
        var head = myLinkedList.getHead();
        System.out.println(getRecDecimalValue(head));
    }

    public static int getRecDecimalValue(MyNode<Integer> head) {
        return calcResult(head, 0);
    }

    private static int calcResult(MyNode<Integer> currentNode, int result) {
        if (null == currentNode)
            return result;
        return calcResult(currentNode.next, 2 * result + currentNode.element);
    }

    public static int getDecimalValue(MyNode<Integer> head) {
        int result = 0;
        MyNode<Integer> currentNode = head;
        while (null != currentNode) {
            result = 2 * result + currentNode.element;
            currentNode = currentNode.next;
        }
        return result;
    }
}
