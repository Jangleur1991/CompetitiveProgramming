package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given the root of a binary search tree, rearrange the tree in in-order so that the leftmost
 * node in the tree is now the root of the tree, and every node has no left child and only one
 * right child.
 *
 * Examples:
 * Input: root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
 * Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 *
 * Input: root = [5,1,7]
 * Output: [1,null,5,null,7]
 *
 */
public class IncreasingOrderSearchTree {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(1);
        list.add(3);

        MyTree<Integer> integerMyTree = MyTree.listToTree(list);
        integerMyTree.display();
        System.out.println();
        MyTree<Integer> increasingOrder = increasingBST(integerMyTree);
        increasingOrder.display();
    }
    public static MyTree<Integer> increasingBST(MyTree<Integer> root) {
        Stack<Integer> elements = new Stack<>();
        mapTreeToStack(root, elements);
        Integer firstElement = elements.pop();
        return createTreeFromStack(elements, new MyTree<>(firstElement));
    }

    private static void mapTreeToStack(MyTree<Integer> myTree, Stack<Integer> elements) {
        if (myTree != null && myTree.element != null) {
            mapTreeToStack(myTree.left, elements);
            elements.add(myTree.element);
            mapTreeToStack(myTree.right, elements);
        }
    }

    private static MyTree<Integer> createTreeFromStack(Stack<Integer> elements, MyTree<Integer> myTree) {
        if (elements.isEmpty())
            return myTree;
        Integer currentElement = elements.pop();
        MyTree<Integer> currentTree = new MyTree<>(currentElement, null, myTree);
        return createTreeFromStack(elements, currentTree);
    }

}
