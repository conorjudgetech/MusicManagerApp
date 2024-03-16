package musicmanager;

/**
 * Stack.java
 * 12/03/24
 * @author Conor Judge
 */

public interface Stack <T> {//<T> the type of elements stored in the stack
    //Adds an item to the top of the stack.
    void push(T item);
    //Removes and returns the item at the top of the stack.
    T pop();
    //Checks if the stack is empty
    boolean isEmpty();
}