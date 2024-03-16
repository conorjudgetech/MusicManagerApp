package musicmanager;

import java.util.ArrayList;

/**
 * ArrayListStack.java
 * 12/03/24
 * @author Conor Judge
 */

public class ArrayListStack<T> implements Stack<T> {{//<T> the type of elements stored in the stack
    private ArrayList<T> stack;
    
    //Constructs an ArrayListStack with an empty ArrayList
    public ArrayListStack() {
        stack = new ArrayList<>();
    }
    
    @Override
    //Pushes a song onto the top of the stack
    public void push(T item) {
        stack.add(item);
    }

    @Override
    //Removes and returns the song at the top of the stack
    public T pop() {
        if (isEmpty()) {
            return null;
        }
        return stack.remove(stack.size() - 1);
    }

    @Override
    //Checks if the stack is empty
    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
