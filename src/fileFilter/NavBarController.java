
// NavBarController.java

package fileFilter;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.HBox;

/**
 * Controller superclass
 * 
 * Manipulates data and states from NavbarModel.java
 * Communicates changes to all views
 * 
 * Extended by all controller subclasses
 *
 * @author averywald
 */
public class NavBarController implements Initializable, Runnable {
    
    // menu bar
    @FXML public MenuBar mb;
    @FXML public Menu preferencesMenu;
    
    @FXML public MenuItem openPref;
    
    @FXML public Menu editMenu;
    @FXML public MenuItem undo;
    @FXML public MenuItem redo;
    
    @FXML public Menu helpMenu;
    @FXML public MenuItem openAbout;
    
    @FXML public Menu windowMenu;
    @FXML public MenuItem mini;
    
    // nav bar
    @FXML public HBox navBar;
    
    @FXML public Button backButton;
    @FXML public Button forwardButton;
    @FXML public Button homeButton;
    
    // Initializable variables
    public URL loc;
    public ResourceBundle rb;
    
    // NavBarModel instance
    NavBarModel nbm;
    
    // methods -----------------------------------------------------------------
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nbm = new NavBarModel();  // initialize NavBarModel object
        this.loc = location;
        this.rb = resources;
    }
    
    // constructor
    void NavBarController() {
        this.initialize(loc, rb);
    }
    
    // override Runnable interface's method
    @Override
    public void run() {
        // navbar model thread to store window history in background
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    // go back to last visited window
    @FXML
    void goBack(ActionEvent event) {

    }

    // undo goBack()
    @FXML
    void goForward(ActionEvent event) {

    }

    // go to the home window
    @FXML
    void goHome(ActionEvent event) {
        
    }

}
