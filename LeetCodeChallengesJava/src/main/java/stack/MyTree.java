package stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyTree<E> {

    E element;
    MyTree<E> left;
    MyTree<E> right;

    int length;

    public MyTree(E element) {
        this.element = element;
        this.length = 1;
    }

    public MyTree(E element, MyTree<E> left, MyTree<E> right) {
        this.element = element;
        this.left = left;
        this.right = right;
        this.length = 1 + left.length + right.length;
    }

    public void display() {
        System.out.println(treeToList());
    }

    public static <E> MyTree<E> listToTree(List<E> list) {
        return listToTreeHelper(list, 0);
    }

    private static <E> MyTree<E> listToTreeHelper(List<E> list, int index) {
        if (2 * index + 1 >= list.size())
            return new MyTree<>(list.get(index));
        MyTree<E> leftMyTree = listToTreeHelper(list, 2 * index + 1);
        MyTree<E> rightMyTree = listToTreeHelper(list, 2 * index + 2);
        return new MyTree<>(list.get(index), leftMyTree, rightMyTree);
    }

    public List<E> treeToList() {
        List<E> list = new ArrayList<>(Collections.nCopies(this.length, null));
        treeToListHelper(list, 0, this);
        return list;
    }

    private void treeToListHelper(List<E> list, int i, MyTree<E> myTree) {
        list.set(i, myTree.element);
        if (2 * i + 1 < list.size()) {
            treeToListHelper(list, 2 * i + 1, myTree.left);
            treeToListHelper(list, 2 * i + 2, myTree.right);
        }
    }

 }
