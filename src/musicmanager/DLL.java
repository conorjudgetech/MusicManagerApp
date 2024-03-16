package musicmanager;

import java.util.ArrayList;

/**
 * DLL.java
 * 12/03/24
 * @author Conor Judge
 */

public interface DLL<T> {//<T> the type of elements stored in the doubly linked list
    //Adds a song to the doubly linked list.
    void add(T item);
    //Removes the first occurrence of the specified song from the doubly linked list.
    boolean remove(T item);
    //Checks if the doubly linked list contains the specified song
    boolean contains(T item);
    //Prints the elements of the doubly linked list
    void printList();
    //Checks if the doubly linked list is empty
    boolean isEmpty();
    //Returns an ArrayList containing all the elements of the doubly linked list
    ArrayList<T> getList(); // Added method to get the list
}