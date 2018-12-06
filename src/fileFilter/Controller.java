
package fileFilter;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 * 
 * Manipulates data and states from FileDataModel.java
 * Communicates changes to FileFilterUI.fxml
 *
 * @author averywald
 */
public class Controller extends NavBarController implements Initializable {
    
    File sourceFile;
    Path sourcePath;
   
    File targetFile;
    Path targetPath;
    
    File[] dirFiles;

    @FXML private VBox basePane;
    
    @FXML private Button sourceDirButton;
    @FXML private Label sourceDirPath;
    
    @FXML private Button targetDirButton;
    @FXML private Label targetDirPath;
    
    @FXML private Button executeButton;
    @FXML private Label statusLabel;
    
    // controller and model instances
    FileDataModel fdm;
    NavBarController nbc;                   // needed if extended???
    
    
    // methods -----------------------------------------------------------------
    
    @Override
    public void initialize(URL location, ResourceBundle resources) { 
        nbc = new NavBarController();  // superclass controller instance
        fdm = new FileDataModel();  // file data model instance
        this.Controller();  // call class constructor
        
        this.loc = location;
        this.rb = resources;
    }
    
    // constructor
    public void Controller() {
        // assign values to class variables
    }

    // choose source directory
    @FXML
    void chooseSource(ActionEvent event) {
        
        final DirectoryChooser dc = new DirectoryChooser();
        Stage stage = (Stage)basePane.getScene().getWindow();
        File file = dc.showDialog(stage);
        File sourcePathString = file.getAbsoluteFile();
        
        if (file != null) {
            sourceDirPath.setText("Source Directory: " + sourcePathString);
            this.sourceFile = sourcePathString;
        } else {
            sourceDirPath.setText("Error: No source directory selected");
        }
        
        System.out.println(this.sourceFile);
        
        this.sourcePath =  sourceFile.toPath();
        
    }

    // choose target directory
    @FXML
    void chooseTarget(ActionEvent event) {
        
        final DirectoryChooser dc = new DirectoryChooser();
        Stage stage = (Stage)basePane.getScene().getWindow();
        File file = dc.showDialog(stage);
        File temp = file.getAbsoluteFile();
        
        if (file != null) {
            targetDirPath.setText("Target Directory: " + temp);
            this.targetFile = temp;
        } else {
            targetDirPath.setText("Error: No target directory selected");
        }
        
        System.out.println(this.targetFile);
        
        this.targetPath = targetFile.toPath();
        
    }

    // execute file transfer from source to target
    // needs to be reimplemented as to not delete the source directory
    @FXML
    void execute(ActionEvent event) throws IOException {

        try {
            Path temp = Files.move(this.sourcePath, this.targetPath, StandardCopyOption.REPLACE_EXISTING);
        
            if (temp == this.targetPath) {
                statusLabel.setText("Success");
            }
            else {
                statusLabel.setText("Failure");
            }

            System.out.println("Target:" + targetFile.getName());
            System.out.println("Terminal:" + temp.getFileName());
        }
        catch (IOException ex) {
            // handle
        }
        
    }
    
    // needs to store all the files in directory path in an array for further manipulation
    void getSourceFiles(File sourcePath) {
        
        this.dirFiles = sourcePath.listFiles();
        Arrays.sort(dirFiles);
        
        for (File dirFile : this.dirFiles) {
            System.out.println(dirFile);
        }
        
    }
    
    // open preferences pane
    @FXML
    void openPreferences(ActionEvent event) throws IOException {
        
        // new scene containing preferences window
        Parent prefParent = FXMLLoader.load(getClass().getResource("/preferences/preferences.fxml"));
        Scene prefWindow = new Scene(prefParent);
        
        // get the stage from MenuBar to put scene on
        Stage window = (Stage)mb.getScene().getWindow();
        
        // stage config
        window.setTitle("File Filter - Preferences");
        window.setScene(prefWindow);
        window.show();
        
    }
    
}

