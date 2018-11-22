
package fileFilter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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

/*
    To do:
    - cleaning
        - clean unused files and directories
        - search & delete entire tree if necessary
    - preferences
        - UI
        - controller functions
            - class state variables for settings
        - save user settings
    - threading for saving scene history 
        - back/forward buttons
*/

public class Controller {
    
    File sourceFile;
    Path sourcePath;
   
    File targetFile;
    Path targetPath;
    
    File[] dirFiles;

    @FXML
    private VBox basePane;
    @FXML
    private MenuBar mb;

    @FXML
    private Menu preferencesMenu;
    @FXML
    private MenuItem openPref;
    
    @FXML
    private Menu editMenu;
    @FXML
    private MenuItem undo;
    @FXML
    private MenuItem redo;
    
    @FXML
    private Menu helpMenu;
    @FXML
    private MenuItem openAbout;
    
    @FXML
    private Menu windowMenu;
    @FXML
    private MenuItem mini;
    
    @FXML
    private Button sourceDirButton;
    @FXML
    private Label sourceDirPath;
    
    @FXML
    private Button targetDirButton;
    @FXML
    private Label targetDirPath;
    
    @FXML
    private Button executeButton;
    @FXML
    private Label statusLabel;
    
    // constructor
    public void Controller() {
    }

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

    @FXML
    void execute(ActionEvent event) throws IOException {
        
        Path temp = Files.move(this.sourcePath, this.targetPath, StandardCopyOption.REPLACE_EXISTING);
        
        if (temp == this.targetPath) {
            statusLabel.setText("Success");
        }
        
        System.out.println("Target:" + targetFile.getName());
        System.out.println("Terminal:" + temp.getFileName());
    }
    
    void getSourceFiles(File sourcePath) {
        
        this.dirFiles = sourcePath.listFiles();
        Arrays.sort(dirFiles);
        
        for (File dirFile : this.dirFiles) {
            System.out.println(dirFile);
        }
        
    }
    
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

