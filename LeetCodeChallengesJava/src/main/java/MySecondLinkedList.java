public class MySecondLinkedList<E> {

    public static void main(String[] args) {
        MySecondLinkedList<Integer> list = new MySecondLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.print();
       // list.reverse();
        list.print();
        list.removeNthFromEnd(list.getHead(), 2);
    }


    MyNode<E> head;

    public MyNode<E> getHead()
    {
        return this.head;
    }

    public void add(E element) {
        if (null == head) {
            this.head = new MyNode<>(element, null);
        } else {
            lastNode(head).next = new MyNode<>(element, null);
        }
    }

    private MyNode lastNode(MyNode<E> currentNode) {
        if (null == currentNode || null == currentNode.next)
            return currentNode;
        return lastNode(currentNode.next);
    }

    public void print() {
        if (null != head) {
            MyNode<E> currentNode = head;
            printLoop(head);
        }
    }

    private void printLoop(MyNode<E> currentNode) {
        if (null != currentNode) {
            System.out.println(currentNode.element);
            printLoop(currentNode.next);
        }
    }

    public void reverse() {
        MyNode<E> prevNode = null;
        while (null != head) {
            MyNode<E> nextNode = head.next;
            head.next = prevNode;
            prevNode = head;
            head = nextNode;
        }
        this.head = prevNode;
    }

    public MyNode<E> removeNthFromEnd(MyNode<E> head, int n) {
        MyNode<E> firstPointer = head;
        MyNode<E> secondPointer = head;

        int counter = 0;
        while(null != secondPointer && counter < n) {
            secondPointer = secondPointer.next;
            counter++;
        }

        if (null == secondPointer) {
            head = head.next;
            return head;
        }

        while(null != secondPointer.next) {
            firstPointer = firstPointer.next;
            secondPointer = secondPointer.next;
        }

        firstPointer.next = firstPointer.next.next;
        return head;
    }

    private static class MyNode<E> {
        E element;
        MyNode<E> next;

        public MyNode(E element, MyNode<E> next) {
            this.element = element;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Element: " + element;
        }
    }
}
