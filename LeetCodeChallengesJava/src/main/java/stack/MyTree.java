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
        this.length = 1 + (left != null ? left.length : 1) + (right != null ? right.length : 1);
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
        return treeToListHelper(new ArrayList<>(Collections.nCopies(this.length, null)), 0, this);
       // return treeToListHelper(new ArrayList<>(Collections.nCopies(1, null)), 0, this);
    }

    //TODO: Rewrite!
    private List<E> treeToListHelper(List<E> list, int i, MyTree<E> myTree) {
//        if (list.size() <= i) {
//            List<E> tmpList = list;
//            list = new ArrayList<>(Collections.nCopies(i+1, null));
//            Collections.copy(list, tmpList);
//       }
        list.set(i, (null != myTree ? myTree.element : null));
        if (null != myTree && (null != myTree.left || null != myTree.right)) {
            list = treeToListHelper(list, 2 * i + 1, myTree.left);
            list = treeToListHelper(list, 2 * i + 2, myTree.right);
        }
        return list;
    }

 }
