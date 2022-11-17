package linkedlist;

import linkedlist.MyLinkedList.MyNode;

/**
 * There is a singly-linked list head and we want to delete a node node in it.
 *
 * You are given the node to be deleted node. You will not be given access to the first node of head.
 *
 * All the values of the linked list are unique, and it is guaranteed that the given node node is not the last node in the linked list.
 *
 * Delete the given node. Note that by deleting the node, we do not mean removing it from memory. We mean:
 *
 * Input: head = [4,5,1,9], node = 5
 * Output: [4,1,9]
 * Explanation: You are given the second node with value 5, the linked list should become 4 -> 1 -> 9 after calling your function.
 */
public class DeleteNodeLinkedList {


    public static void main(String[] args) {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.addElement(4);
        myLinkedList.addElement(5);
        myLinkedList.addElement(1);
        myLinkedList.addElement(9);
        MyNode<Integer> node = myLinkedList.getNodeBy(5);
        System.out.println(node.element);
        deleteNode(node);
        System.out.println();
        myLinkedList.printElements();
    }

    private static void deleteNode(MyNode<Integer> node) {
        node.element = node.next.element;
        node.next = node.next.next;
    }
}
