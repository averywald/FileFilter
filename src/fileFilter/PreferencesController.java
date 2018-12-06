
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
import javafx.scene.control.CheckBox;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 * 
 * Manipulates data and states from PreferencesDataModel.java
 * Communicates changes to Preferences.fxml
 *
 * @author averywald
 */
public class PreferencesController extends fileFilter.NavBarController implements Initializable {

    @FXML private CheckBox cleanUnusedToggle;
    @FXML private CheckBox deleteEmptyToggle;
    @FXML private CheckBox replaceDuplicatesToggle;
    
    // controller and model instances
    fileFilter.NavBarController nbc;            // needed if extends???
    PreferencesDataModel pdm;
    
    // methods -----------------------------------------------------------------

    // Initializes the controller class.
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // superclass instance
        nbc = new fileFilter.NavBarController();
        // preferences model instance
        pdm = new PreferencesDataModel();
        
        this.loc = location;
        this.rb = resources;
    }
    
    // switch clean unused files state
    @FXML
    void setCleanUnused(ActionEvent event) {
        Boolean state = !cleanUnusedToggle.isSelected();
        pdm.setCleanUnused(state);
    }

    // switch replace duplicate files state
    @FXML
    void setReplaceDuplicates(ActionEvent event) {
        Boolean state = !replaceDuplicatesToggle.isSelected();
        pdm.setReplaceDuplicates(state);
    }

    // switch delete empty directories state
    @FXML
    void setDeleteEmpty(ActionEvent event) {
        Boolean state = !deleteEmptyToggle.isSelected();
        pdm.setDeleteEmptyFolders(state);
    }
    
    // open up the main scene
    @FXML
    private void openMain(ActionEvent event) throws IOException {
        
        // nbc.openMain();
        
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
