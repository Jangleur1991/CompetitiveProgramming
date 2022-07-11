package linkedlist;


//TODO: generalise the traversing over the array
public class MyLinkedList<E> {
    MyNode<E> head;

    public MyNode<E> getHead() {
        return this.head;
    }

    public void addElement(E element) {
        if (null == head) {
            head = new MyNode<>(element, null);
        } else {
            MyNode<E> currentNode = head;
            while(null != currentNode.next) {
                currentNode = currentNode.next;
            }
            currentNode.next = new MyNode<>(element, null);
        }
    }

    public void deleteElement(E element) {
        if (null != head) {
            MyNode<E> currentNode = head;
            while(null != currentNode.next) {
                if (element == currentNode.next.element) {
                    currentNode.next = currentNode.next.next;
                }
                currentNode = currentNode.next;
            }
        }
    }

    //TODO: Refactoring
    public MyNode<E> getNodeBy(E element) {
        if (null != head) {
            MyNode<E> currentNode = head;
            while(null != currentNode.next) {
                if (currentNode.element == element) {
                    return currentNode;
                }
                currentNode = currentNode.next;
            }
            return null;
        }
        return null;
    }

    public void printElements() {
        if (null != head) {
            MyNode<E> currentNode = head;
            while (null != currentNode) {
                System.out.println(currentNode.element);
                currentNode = currentNode.next;
            }
        }
    }

    public static class MyNode<E> {
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
