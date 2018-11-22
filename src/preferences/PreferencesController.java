
package preferences;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author averywald
 */
public class PreferencesController implements Initializable {

    @FXML private MenuBar mb;
    
    @FXML private Menu windowMenu;
    @FXML private MenuItem mini;
    
    @FXML private Menu editMenu;
    @FXML private MenuItem undo;
    @FXML private MenuItem redo;
    
    @FXML private Menu helpMenu;
    @FXML private MenuItem openAbout;
    
    @FXML private HBox navBar;
    @FXML private Button backButton;

    // Initializes the controller class.
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    
    

    // open up the main scene
    @FXML
    private void openMain(ActionEvent event) throws IOException {
        
        // new scene containing preferences window
        Parent prefParent = FXMLLoader.load(getClass().getResource("/fileFilter/fileFilterUI.fxml"));
        Scene prefWindow = new Scene(prefParent);
        
        // get the stage from MenuBar to put scene on
        Stage window = (Stage)mb.getScene().getWindow();
        
        // stage config
        window.setTitle("File Filter - Transfer");
        window.setScene(prefWindow);
        window.show();
        
    }
    
}
