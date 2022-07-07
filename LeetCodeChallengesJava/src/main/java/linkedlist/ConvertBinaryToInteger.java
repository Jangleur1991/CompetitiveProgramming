package linkedlist;

/**
 * Given head which is a reference node to a singly-linked list. The value of each node in the linked list is either 0 or 1. The linked list holds the binary representation of a number.
 *
 * Return the decimal value of the number in the linked list.
 */
public class ConvertBinaryToInteger {
    public int getDecimalValue(ListNode head) {
        int result = 0;
        ListNode currentNode = head;
        while (null != currentNode) {
            result = 2*result+currentNode.val;
            currentNode = currentNode.next;
        }
        return result;
    }
}
