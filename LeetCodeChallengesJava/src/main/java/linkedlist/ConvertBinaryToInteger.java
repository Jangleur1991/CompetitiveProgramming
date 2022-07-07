package linkedlist;

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
