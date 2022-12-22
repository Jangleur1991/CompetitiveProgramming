package stack;

import java.util.List;

public class MyNTree {
    private int val;
    private List<MyNTree> children;

    public MyNTree(int val) {
        this.val = val;
    }

    public MyNTree(int val, List<MyNTree> children) {
        this.val = val;
        this.children = children;
    }


}
