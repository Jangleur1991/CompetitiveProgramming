package stack;

import java.util.*;

public class MyNTree<E> {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(null);
//        list.add(3);
//        list.add(2);
//        list.add(4);
//        list.add(null);
//        list.add(5);
//        list.add(6);
        // [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
        list.add(1);
        list.add(null);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(null);
        list.add(null);
        list.add(6);
        list.add(7);
        list.add(null);
        list.add(8);
        list.add(null);
        list.add(9);
        list.add(10);
        list.add(null);
        list.add(null);
        list.add(11);
        list.add(null);
        list.add(12);
        list.add(null);
        list.add(13);
        list.add(null);
        list.add(null);
        list.add(14);
        MyNTree<Integer> integerMyNTree = addChildern(list.subList(2, list.size()), 1, 1, new MyNTree<>(list.get(0)));
        Map<Integer, List<Integer>> mapListToChildren = mapListToChildren(list.subList(2, list.size()), 1);
        MyNTree<Integer> myTree = buildTree(list);
        System.out.println(integerMyNTree);
    }

    private static MyNTree<Integer> mapListToTree(List<Integer> list) {
        MyNTree<Integer> tree = new MyNTree<>(list.get(0));
        return addChildern(list.subList(1, list.size()), 1, 1, tree);
    }

    private static List<Integer> calcChildren(int nthNonNullNumber, List<Integer> childLevel) {
        int nthIndexOfNull = nthIndexOfNull(childLevel, nthNonNullNumber);
        if (nthNonNullNumber>1) {
            int indxOfNullBefore = nthIndexOfNull(childLevel, nthNonNullNumber-1)+1;
            return indxOfNullBefore >= nthIndexOfNull
                    ? List.of()
                    : childLevel.subList(indxOfNullBefore, nthIndexOfNull);
        }
        return childLevel.subList(0, nthIndexOfNull);
    }


    private static MyNTree<Integer> buildTree(List<Integer> list) {
        MyNTree<Integer> startNode = new MyNTree<>(list.get(0));
        Map<Integer, List<Integer>> children = mapListToChildren(list.subList(2, list.size()), 1);
        Integer startIndexOfNewList = children.get(0).get(0);
        List<Integer> tempList = list.subList(2, list.size());
        List<Integer> newList = tempList.subList(startIndexOfNewList, tempList.size());
        return buildTreeOfChildren(newList, 1, children, startNode);
    }
    private static MyNTree<Integer> buildTreeOfChildren(List<Integer> list,
                                              int numberOfElement,
                                              Map<Integer, List<Integer>> children,
                                              MyNTree<Integer> result) {
        if (children.size() == 1)
            return result;

        int numberOfChildren = children.values().stream().mapToInt(List::size).sum() - 1;
        Map<Integer, List<Integer>> newChildren = mapListToChildren(list, numberOfChildren);
        Integer startIndexOfNewList = newChildren.get(0).get(0);
        List<Integer> newList = list.subList(startIndexOfNewList, list.size());

        List<Integer> currentChildren = children.get(numberOfElement);
        List<MyNTree<Integer>> childs = new ArrayList<>();
        if (null != currentChildren) {
            for (int i = 0; i < currentChildren.size(); i++) {
                MyNTree<Integer> child = buildTreeOfChildren(newList, i + 1, newChildren, new MyNTree<>(currentChildren.get(i)));
                childs.add(child);
            }
        }
        result.setChildren(childs);
        return result;
    }
    private static MyNTree<Integer> addChildern(List<Integer> list, int numberOfElement,
                                                int nonNullNumber, MyNTree<Integer> result) {

        // list
        // aktuelles level
        // neues level
        // gehe durch aktuelles level
            // berechne fuer aktuelles element die kinder aus neues level
            // fuege kinder zu aktuelles element hinzu

        if (list.isEmpty())
            return result;

        //Wird mehrmals verwendet fuer jedes element... schlecht! Ein mal sollte reichen!
        ListToTreeMapper listToTreeMapper = getMapper(list, nonNullNumber);
        List<Integer> level = listToTreeMapper.getLevel();
        List<Integer> newList = listToTreeMapper.getNewList();
        int numberOfNonNullElements = listToTreeMapper.getNumberOfNonNullElements();
        Map<Integer, List<Integer>> listToChildren = mapListToChildren(list, nonNullNumber);

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


    private static ListToTreeMapper getMapper(List<Integer> list, int nonNullNumber) {
        List<Integer> level = new ArrayList<>();
        List<Integer> newList = new ArrayList<>();
        int counter = 0;
        for (int index=0; index < list.size(); index++) {
            Integer element = list.get(index);
            if (counter < nonNullNumber) {
                if (Objects.equals(element, null))
                    counter++;
                level.add(element);
            } else {
                newList.add(element);
            }
        }
        return new ListToTreeMapper(level, newList, level.size()-counter);
    }

    private static Map<Integer, List<Integer>> mapListToChildren(List<Integer> list, int nonNullNumber) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int counter = 1;
        List<Integer> children = new ArrayList<>();
        for (int i = 0; i < list.size() && counter <= nonNullNumber; i++) {
            Integer element = list.get(i);
            if (null != element) {
                children.add(element);
            } else {
                map.put(counter, children);
                if (counter == nonNullNumber)
                    map.put(0, List.of(i+1));
                children = new ArrayList<>();
                counter++;
            }
        }
        if (map.isEmpty()) {
            map.put(counter, children);
            map.put(0, List.of(list.size()));
        }
        return map;
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
