package stack;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree<E> {

    E element;
    BinaryTree<E> left;
    BinaryTree<E> right;

    public BinaryTree(E element) {
        this.element = element;
    }

    public BinaryTree(E element, BinaryTree<E> left, BinaryTree<E> right) {
        this.element = element;
        this.left = left;
        this.right = right;
    }

    public void display() {
        System.out.println(element);
        if (null != left)
            left.display();
        if (null != right)
            right.display();
    }

    //TODO
    public static <E> BinaryTree<E> listToTree(List<E> list) {
        return null;
    }

    public List<E> treeToList() {
        List<E> arrayList = new ArrayList<>();
        arrayList.add(element);
        treeToArrayHelper(arrayList, this);
        return arrayList;
    }

    private void treeToArrayHelper(List<E> arrayList, BinaryTree<E> tree) {
        if (null != tree.left)
            arrayList.add(tree.left.element);
        if (null != tree.right)
            arrayList.add(tree.right.element);
        if (null != tree.left)
            treeToArrayHelper(arrayList, tree.left);
        if (null != tree.right)
            treeToArrayHelper(arrayList, tree.right);
    }
 }
