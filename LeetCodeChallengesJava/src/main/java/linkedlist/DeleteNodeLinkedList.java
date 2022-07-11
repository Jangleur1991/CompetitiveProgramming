package linkedlist;

import linkedlist.MyLinkedList.MyNode;

public class DeleteNodeLinkedList {


    public static void main(String[] args) {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.addElement(4);
        myLinkedList.addElement(5);
        myLinkedList.addElement(1);
        myLinkedList.addElement(9);
        myLinkedList.printElements();
        MyNode<Integer> node = myLinkedList.getNodeBy(5);
        System.out.println();
        deleteNode(node);
        myLinkedList.printElements();
    }

    private static void deleteNode(MyNode<Integer> node) {
        node.element = node.next.element;
        node.next = node.next.next;
    }
}
