package musicmanager;

import java.util.ArrayList;

/**
 * ArrayListDLL.java
 * 12/03/24
 * @author Conor Judge
 */

public class ArrayListDLL<T> implements DLL<T> {//<T> the type of elements stored in the list
    private ArrayList<T> list;
    
    //Constructs an ArrayListDLL with an empty ArrayList
    public ArrayListDLL() {
        list = new ArrayList<>();
    }
    
    @Override
    //Adds a song to the end of the list
    public void add(T item) {
        list.add(item);
    }

    @Override
    //Removes the first occurrence of the song from the list, if it is present
    public boolean remove(T item) {
        return list.remove(item);
    }

    @Override
    //Checks if the list contains the song
    public boolean contains(T item) {
        return list.contains(item);
    }

    @Override
    //Prints all the songs in the list
    public void printList() {
        for (T item : list) {
            System.out.println(item);
        }
    }
    
    @Override
    //Retrieves the underlying ArrayList.
    public ArrayList<T> getList() {
        return list;
    }

    @Override
    //Checks if the list is empty.
    public boolean isEmpty() {
        return list.isEmpty();
    }
    
    //Removes and returns the last song from the list
    public T pop() {
        if (isEmpty()) {
            return null;
        }
        return list.remove(list.size() - 1);
    }
}