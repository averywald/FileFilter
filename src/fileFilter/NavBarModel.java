
// NavBarModel.java

package fileFilter;

import java.util.ArrayList;

/**
 * Model holding FXML navbar data and states
 * Maintains window history for navigation
 *
 * @author averywald
 */
public class NavBarModel {
    
    private String currentWindow;
    private String lastWindow;
    private ArrayList<String> windowHistory;  // holds window history
    
    // methods -----------------------------------------------------------------
    
    // constructor
    void NavBarModel() {
        // to do
        // get the current window
        // push current window onto window history
    }
    
    // getters
    public String getCurrentWindow() {
        return this.currentWindow;
    }
    public String getLastWindow() {
        return this.lastWindow;
    }
    public ArrayList<String> getWindowHistory() {
        return this.windowHistory;
    }
    
    // setters
    public void setCurrentWindow(String window) {
        this.currentWindow = window;
    }
    
    public void updateWindowHistory() {
        // add new history to the windowHistory ArrayList
    }
    
}
