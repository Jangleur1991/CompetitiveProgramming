package stack;

import java.util.*;

public class TreeMapper {

    public MyNTree<Integer> listToTree(List<Integer> list) {
        if (list.isEmpty()) return null;
        List< MyNTree<Integer>> currentLevel = new ArrayList< MyNTree<Integer>>();
        MyNTree<Integer> root = new  MyNTree<Integer>(list.get(0));
        currentLevel.add(root);
        int i = 1;
        while (i < list.size()) {
            List< MyNTree<Integer>> nextLevel = new ArrayList< MyNTree<Integer>>();
            for ( MyNTree<Integer> node : currentLevel) {
                while(i < list.size() && list.get(i) == null) {
                    i++;
                }
                if (i < list.size() && list.get(i) != null) {
                    MyNTree<Integer> left = new  MyNTree<Integer>(list.get(i));
                    //node.addChild(left);
                    nextLevel.add(left);
                }
                i++;
            }
            currentLevel = nextLevel;
        }
        return root;
    }
}





