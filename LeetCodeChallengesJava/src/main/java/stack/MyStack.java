package stack;


public class MyStack<E> {

    private MyStackNode<E> tail;

    public void push(E element) {
        if (null == tail) {
            tail = new MyStackNode<>(null, element);
        } else {
            tail = new MyStackNode<>(tail, element);
        }
    }

    public E pop() {
        E ans = tail.element;
        tail = tail.previous;
        return ans;
    }

    public void display() {
        MyStackNode<E> currentNode = tail;
        while (null != currentNode) {
            System.out.println(currentNode.element);
            currentNode = currentNode.previous;
        }
    }

    private static class MyStackNode<E> {
        E element;
        MyStackNode<E> previous;

        public MyStackNode(MyStackNode<E> previous, E element) {
            this.previous = previous;
            this.element = element;
        }
    }


}
