package stack;

import java.util.List;

public class ListToTreeMapper {
    private List<Integer> level;
    private List<Integer> newList;
    private int numberOfNonNullElements;

    public ListToTreeMapper(List<Integer> level, List<Integer> newList, int numberOfNonNullElements) {
        this.level = level;
        this.newList = newList;
        this.numberOfNonNullElements = numberOfNonNullElements;
    }

    public List<Integer> getLevel() {
        return level;
    }

    public List<Integer> getNewList() {
        return newList;
    }

    public int getNumberOfNonNullElements() {
        return numberOfNonNullElements;
    }
}
