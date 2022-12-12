package stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTree<E> {

    E element;
    BinaryTree<E> left;
    BinaryTree<E> right;

    int length;

    public BinaryTree(E element) {
        this.element = element;
        this.length = 1;
    }

    public BinaryTree(E element, BinaryTree<E> left, BinaryTree<E> right) {
        this.element = element;
        this.left = left;
        this.right = right;
        this.length = 1 + left.length + right.length;
    }

    public void display() {
        System.out.println(treeToList());
    }

    public static <E> BinaryTree<E> listToTree(List<E> list) {
        return listToTreeHelper(list, 0);
    }

    private static <E> BinaryTree<E> listToTreeHelper(List<E> list, int index) {
        if (2 * index + 1 >= list.size())
            return new BinaryTree<>(list.get(index));
        BinaryTree<E> leftTree = listToTreeHelper(list, 2 * index + 1);
        BinaryTree<E> rightTree = listToTreeHelper(list, 2 * index + 2);
        return new BinaryTree<>(list.get(index), leftTree, rightTree);
    }

    public List<E> treeToList() {
        List<E> list = new ArrayList<>(Collections.nCopies(this.length, null));
        treeToListHelper(list, 0, this);
        return list;
    }

    private void treeToListHelper(List<E> list, int i, BinaryTree<E> tree) {
        list.set(i, tree.element);
        if (2 * i + 1 < list.size()) {
            treeToListHelper(list, 2 * i + 1, tree.left);
            treeToListHelper(list, 2 * i + 2, tree.right);
        }
    }

 }
