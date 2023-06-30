import stack.MyTree;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        MyTree<Integer> myTree1 = new MyTree<>(1);
        MyTree<Integer> myTree2 = new MyTree<>(2);
        MyTree<Integer> myTree3 = new MyTree<>(3, myTree1, myTree2);
        //System.out.println(tree3.getLength());
        //System.out.println(tree3.treeToList2());
//        root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
        List<Integer> list = new ArrayList<>();
//        list.add(5);
//        list.add(3);
//        list.add(6);
//        list.add(2);
//        list.add(4);
//        list.add(null);
//        list.add(8);
//        list.add(1);
//        list.add(null);
//        list.add(null);
//        list.add(null);
//        list.add(null);
//        list.add(null);
//        list.add(7);
//        list.add(9);
        list.add(1);
        list.add(null);
        list.add(2);
        list.add(null);
        list.add(null);
        list.add(null);
        list.add(3);
        System.out.println(list.size());
        MyTree<Integer> integerMyTree = MyTree.listToTree(list);
        //integerBinaryTree.display();
       // System.out.println(integerBinaryTree.treeToList());
        integerMyTree.display();
    }

}
