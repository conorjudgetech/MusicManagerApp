package musicmanager;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * MusicManagerApp.java
 * 12/03/24
 * @author Conor Judge
 */

public class MusicManagerApp {
    // Stack for managing added songs
    private ArrayListStack<String> stack;
    // Doubly linked lists for managing songs in different categories
    private ArrayListDLL<String> list1, list2, list3;
    // Flag to indicate whether repeating lists is enabled
    private boolean repeatEnabled = false;//enables repeat

    
    //Constructor to initialize stacks and lists
    public MusicManagerApp() {
        stack = new ArrayListStack<>();
        list1 = new ArrayListDLL<>();
        list2 = new ArrayListDLL<>();
        list3 = new ArrayListDLL<>();
    }
    
    //Setter method for enabling/disabling list repeating
    public void setRepeatEnabled(boolean enabled) {// enables repeat
    this.repeatEnabled = enabled;
    }
    
    //Adds a song to Liked Playlist and the stack
    public void addItem(String item) {
        list1.add(item);
        if (stack != null) {
            stack.push(item);
        }
    }
    
    //Deletes a song
    public void deleteItem(String item) {
        list1.remove(item);
        list2.remove(item);
        list3.remove(item);
    }
    
    //Moves the last song from Liked Playlist to Genre A Playlist
    public void moveLastItemToList2() {
        if (!list1.isEmpty()) {
            String lastItem = list1.pop();
            if (!list2.contains(lastItem)) {
                list2.add(lastItem);
            }
        }
    }
    
    //Moves the last item from Liked Playlist to Genre B Playlist
    public void moveLastItemToList3() {
        if (!list1.isEmpty()) {
            String lastItem = list1.pop();
            if (!list3.contains(lastItem)) {
                list3.add(lastItem);
            }
        }
    }
    
    
    //Generates a string of the list
    public String printList(int listNumber) {
        StringBuilder output = new StringBuilder("");
        ArrayListDLL<String> selectedList;
        if (listNumber == 1) {
            selectedList = list1;
        } else if (listNumber == 2) {
            selectedList = list2;
        } else if (listNumber == 3) {
            selectedList = list3;
        } else {
            return "Invalid list number";
        }
        
        // Repeat the list if repeatEnabled is true
        if (repeatEnabled) {
            for (int i = 0; i < 3; i++) { // Repeats the list 3 times to demonstrate repeat function
                for (String item : selectedList.getList()) {
                    output.append(item).append("\n");
                }
            }
        } else {
            // Print the list only once
            for (String item : selectedList.getList()) {
                output.append(item).append("\n");
            }
        }

        return output.toString();
        }

    //Searches for songs containing the specified query string
    public String searchItem(String query) {
        ArrayList<String> searchResults = new ArrayList<>();

        // Search through Liked List
        Iterator<String> iterator1 = list1.getList().iterator();
        while (iterator1.hasNext()) {
            String item = iterator1.next();
            if (item.contains(query)) {
                searchResults.add(item);
            }
        }

        // Search through Genre A
        Iterator<String> iterator2 = list2.getList().iterator();
        while (iterator2.hasNext()) {
            String item = iterator2.next();
            if (item.contains(query)) {
                searchResults.add(item);
            }
        }

        // Search through Genre B
        Iterator<String> iterator3 = list3.getList().iterator();
        while (iterator3.hasNext()) {
            String item = iterator3.next();
            if (item.contains(query)) {
                searchResults.add(item);
            }
        }

        // Construct the output string
        StringBuilder output = new StringBuilder();
        if (!searchResults.isEmpty()) {
            output.append("Search results:\n");
            for (String result : searchResults) {
                output.append(result).append("\n");
            }
        } else {
            output.append("Sorry no matching songs were found.");
        }
        return output.toString();
    }

    //main method
    public static void main(String[] args) {
        // Create an instance of MusicManagerApp
        MusicManagerApp myApp = new MusicManagerApp();
        
        // Create an instance of MusicManagerGUI
        MusicManagerGUI myGUI = new MusicManagerGUI();
        myGUI.setVisible(true);
        
        //  action listeners to GUI components and handle events
        myGUI.getAddBTN().addActionListener(e -> {
            String addItem = myGUI.getAddTF().getText();
            myApp.addItem(addItem);
            myGUI.getAddTF().setText(""); // Clears the text field after adding
        });
        
        // action listener for deleting item
        myGUI.getDeleteBTN().addActionListener(e -> {
            String deleteItem = myGUI.getDeleteTF().getText();
            myApp.deleteItem(deleteItem);
            myGUI.getDeleteTF().setText(""); // Clears the text field after deleting
        });
  
        // action listener for moving last item in Liked to Genre A
        myGUI.getMove2BTN().addActionListener(e -> {
            myApp.moveLastItemToList2();
        });
        
        // action listener for moving last item in Liked to Genre B
        myGUI.getMove3BTN().addActionListener(e -> {
            myApp.moveLastItemToList3();
        });
        
        // action listener for repeat toggle button
        myGUI.getRepeatTGL().addActionListener(e -> {
        boolean enabled = myGUI.getRepeatTGL().isSelected();
        myApp.setRepeatEnabled(enabled);
        });


        // action listener for searching
        myGUI.getSearchBTN().addActionListener(e -> {
            String searchQuery = myGUI.getSearchTF().getText();
            String searchResult = myApp.searchItem(searchQuery);
            myGUI.getOutputTextArea().setText(searchResult); // Display search result
            myGUI.getSearchTF().setText(""); // Clears the text field after searching
        });
        
        // action listener for printing Liked Playlist
        myGUI.getPrintList1BTN().addActionListener(e -> {
            String list1Result = myApp.printList(1);
            myGUI.getOutputTextArea().setText(list1Result); // Display list1
        });
        
        // action listener for printing Genre A playlist
        myGUI.getPrintList2BTN().addActionListener(e -> {
            String list2Result = myApp.printList(2);
            myGUI.getOutputTextArea().setText(list2Result); // Display list2
        });
        
        // action listener for printing Genre B playlist
        myGUI.getPrintList3BTN().addActionListener(e -> {
            String list3Result = myApp.printList(3);
            myGUI.getOutputTextArea().setText(list3Result); // Display list3
        });
    }
}