import linkedlist.MyLinkedList;

public class MySecondLinkedList<E> {

    public static void main(String[] args) {
        MySecondLinkedList<Object> linkedList = new MySecondLinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.display();
        linkedList.reverse();
        System.out.println();
        linkedList.display();
    }

    private MyNode<E> head;

    public void add(E element) {
        if (null == head) {
            head = new MyNode<>(element, null);
        } else {
            MyNode<E> currentNode = head;
            while (null != currentNode.next) {
                currentNode = currentNode.next;
            }
            currentNode.next = new MyNode<>(element, null);
        }
    }

    public void display() {
        if (null != head) {
            MyNode<E> currentNode = head;
            while (null != currentNode) {
                System.out.println(currentNode.element);
                currentNode = currentNode.next;
            }
        }
    }

    public void reverse() {
        //reverse(head);
        reverseWithLoop();
    }


    private MyNode<E> reverse(MyNode<E> node) {
        if (null == node.next) {
            this.head=node;
            return node;
        }
        MyNode<E> nextNode = reverse(node.next);
        nextNode.next = node;
        node.next = null;
        return node;
    }


    private void reverseWithLoop() {
        MyNode<E> prevNode = null;
        while (null != head) {
            MyNode<E> nextNode = head.next;
            head.next = prevNode;
            prevNode = head;
            head = nextNode;
        }
        head = prevNode;
    }

    private static class MyNode<E> {
        E element;
        MyNode<E> next;

        public MyNode(E element, MyNode<E> next) {
            this.element = element;
            this.next = next;
        }
    }
}
