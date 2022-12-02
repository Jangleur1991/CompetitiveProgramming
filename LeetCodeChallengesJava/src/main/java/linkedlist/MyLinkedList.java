package linkedlist;


import java.util.function.Consumer;
import java.util.function.Predicate;

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

    public void addElementRec(E element) {
        if (null == head) {
            head = new MyNode<>(element, null);
        } else {
            lastNode(head).next = new MyNode<>(element, null);
        }
    }

    private MyNode<E> lastNode(MyNode<E> currentNode) {
        if (null == currentNode || null == currentNode.next)
            return currentNode;
        return lastNode(currentNode.next);
    }

    public void deleteElement(E element) {
        if (null != head) {
            MyNode<E> currentNode = head;
            if (element == head.element) {
                head = head.next;
            } else {
                while (null != currentNode && null != currentNode.next) {
                    if (element == currentNode.next.element) {
                        currentNode.next = currentNode.next.next;
                    }
                    currentNode = currentNode.next;
                }
            }
        }
    }

    public void deleteElementRec(E element) {
        traverseNodes(head, (MyNode<E> node) -> {
            if (element == head.element) {
                head = head.next;
            } else if (null != node.next && element == node.next.element) {
                node.next = node.next.next;
            }
        });
    }

    private MyNode<E> traverseNodes(MyNode<E> currentNode, Consumer<MyNode<E>> consumer) {
        if (null == currentNode)
            return null;
        consumer.accept(currentNode);
        return traverseNodes(currentNode.next, consumer);
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

    public MyNode<E> getNodeRecBy(E element) {
        return traverseNodes(head, (MyNode<E> node) -> node.element == element);
    }

    private MyNode<E> traverseNodes(MyNode<E> node, Predicate<MyNode<E>> predicate) {
        if (null == node)
            return null;
        return predicate.test(node)
                ? node
                : traverseNodes(node.next, predicate);
    }

    public void reverse() {
        reverseWithLoop();
        //reverseWithRecursion(this.head);
    }

    private MyNode<E> reverseWithRecursion(MyNode<E> head) {
        if (null == head || null == head.next) {
            this.head = head;
            return head;
        }
        MyNode<E> newHead = reverseWithRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    private void reverseWithLoop() {
        MyNode<E> prevNode = null;
        while (null != head) {
            MyNode<E> nextNode = head.next;
            head.next = prevNode;
            prevNode = head;
            head = nextNode;
        }
        this.head = prevNode;
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
