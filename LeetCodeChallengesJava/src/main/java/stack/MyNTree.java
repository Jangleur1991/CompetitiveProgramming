package stack;

import java.util.*;

public class MyNTree<E> {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(null);
        list.add(2);
        list.add(3);
        list.add(null);
        list.add(null);
        list.add(4);
        list.add(5);
        list.add(null);
        list.add(null);
        list.add(6);
        System.out.println(calcChildren(2, list));
        MyNTree<Integer> integerMyNTree = addChildern(list.subList(2, list.size()), 1, 1, new MyNTree<>(list.get(0)));
        System.out.println(integerMyNTree);
    }

    private static MyNTree<Integer> mapListToTree(List<Integer> list) {
        MyNTree<Integer> tree = new MyNTree<>(list.get(0));
        return addChildern(list.subList(1, list.size()), 1, 1, tree);
    }

    private static List<Integer> calcChildren(int nthNonNullNumber, List<Integer> childLevel) {
        int nthIndexOfNull = nthIndexOfNull(childLevel, nthNonNullNumber);
        if (nthNonNullNumber>1) {
            int indxOfNullBefore = nthIndexOfNull(childLevel, nthNonNullNumber-1);
            return childLevel.subList(indxOfNullBefore+1, nthIndexOfNull);
        }
        return childLevel.subList(0, nthIndexOfNull);
    }

    private static MyNTree<Integer> addChildern(List<Integer> list, int numberOfElement,
                                                long nonNullNumber, MyNTree<Integer> result) {

        // list
        // aktuelles level
        // neues level
        // gehe durch aktuelles level
            // berechne fuer aktuelles element die kinder aus neues level
            // fuege kinder zu aktuelles element hinzu

        if (list.isEmpty())
            return result;

        int nthIndexOfNull = nthIndexOfNull(list, nonNullNumber);
        List<Integer> level = list.subList(0, nthIndexOfNull);
        long numberOfNonNullElements = level.stream().filter(Objects::nonNull).count();
        List<Integer> newList = nthIndexOfNull != list.size()
                ?  list.subList(nthIndexOfNull + 1, list.size())
                :   List.of();

        List<MyNTree<Integer>> children = new ArrayList<>();

                List<Integer> childIntegers = calcChildren(numberOfElement, level);
                for (int i = 0; i < childIntegers.size(); i++) {
                    MyNTree<Integer> newChild = addChildern(newList, i+1, numberOfNonNullElements, new MyNTree<>(childIntegers.get(i)));
                    children.add(newChild);
                }
                // calc children of child


        result.setChildren(children);
        return result;
    }


    private static Map<Integer, List<Integer>> splitList(List<Integer> list,
                                                         long nonNullNumber,
                                                         int index,
                                                         Map<Integer, List<Integer>> levels) {
        if (!list.isEmpty()) {
           // System.out.println("Remaining List: " + list);
            int numberOfFirstNonNullElements = nthIndexOfNull(list, nonNullNumber);
            //System.out.println("numberOfFirstNonNullElements: " + numberOfFirstNonNullElements);
            List<Integer> level = list.subList(0, numberOfFirstNonNullElements+1);
            levels.put(index, level);
            long numberOfNonNullElements = level.stream().filter(Objects::nonNull).count();
           // System.out.println("Current Level: " + level);
            //System.out.println("Number of non null: " + numberOfNonNullElements);
            return splitList(list.subList(numberOfFirstNonNullElements+1, list.size()), numberOfNonNullElements, index+1, levels);
        }
        return levels;
    }

    private static int nthIndexOfNull(List<Integer> list, long number) {
        if (list.isEmpty()) return -1;
        int counter = 0;
        for (int index=0; index < list.size(); index++) {
            if (Objects.equals(list.get(index), null)) {
                counter++;
            }
            if (counter == number)
                return index;
        }
        return list.size();
    }

    private E val;
    private List<MyNTree<E>> children;

    public MyNTree(E val) {
        this.val = val;
    }

    public MyNTree(E val, List<MyNTree<E>> children) {
        this.val = val;
        this.children = children;
    }

    public void setChildren(List<MyNTree<E>> children) {
        this.children = children;
    }


}
