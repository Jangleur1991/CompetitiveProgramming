package linkedlist;

import java.util.*;

/**
 * Design a HashSet without using any built-in hash table libraries.
 *
 * Implement MyHashSet class:
 *
 * void add(key) Inserts the value key into the HashSet.
 * bool contains(key) Returns whether the value key exists in the HashSet or not.
 * void remove(key) Removes the value key in the HashSet. If key does not exist in the HashSet, do nothing.
 */

//TODO: Look for alternative implementations and right about HashSet!
//TODO: why the use of a linkedlist? why not both arrayLists?
public class MyHashSet {

    private final int ARRAY_LIST_SIZE = 100;
    private final List<List<Integer>> arrayList;

    public MyHashSet() {
        //Init with nulls
        arrayList = new ArrayList<>(Collections.nCopies(ARRAY_LIST_SIZE, null));
    }

    public void add(int key) {
        List<Integer> childList = getLinkedList(key);
        if (null == childList) {
            List<Integer> linkedList = new LinkedList<>();
            linkedList.add(key);
            arrayList.set(getIndex(key), linkedList);
        } else {
            if (!childList.contains(key)) {
                childList.add(key);
            }
        }
    }

    private List<Integer> getLinkedList(int key) {
        return arrayList.get(getIndex(key));
    }

    private int getIndex(int key) {
        //Key must be stored in an ArrayList of length 100
        return key % ARRAY_LIST_SIZE;
    }

    public void remove(int key) {
        List<Integer> childList = getLinkedList(key);
        if (null != childList) {
            //Conversion to Integer. Otherwise it would delete the index and not the key.
            childList.remove(Integer.valueOf(key));
        }
    }

    public boolean contains(int key) {
        List<Integer> childList = getLinkedList(key);
        return null != childList && childList.contains(key);
    }

}
