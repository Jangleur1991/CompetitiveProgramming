package stack;

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

    public MyTree<Integer> increasingBST(MyTree<Integer> root) {
        Stack<Integer> elements = new Stack<>();
        mapTreeToStack(root, elements);
        Integer firstElement = elements.pop();
        return createTreeFromStack(elements, new MyTree<>(firstElement));
    }

    private void mapTreeToStack(MyTree<Integer> myTree, Stack<Integer> elements) {
        if (myTree != null) {
            mapTreeToStack(myTree.left, elements);
            elements.add(myTree.element);
            mapTreeToStack(myTree.right, elements);
        }
    }

    private MyTree<Integer> createTreeFromStack(Stack<Integer> elements, MyTree<Integer> myTree) {
        if (elements.isEmpty())
            return myTree;
        Integer currentElement = elements.pop();
        MyTree<Integer> right = createTreeFromStack(elements, myTree);
        return new MyTree<>(currentElement, null, right);
    }

}
