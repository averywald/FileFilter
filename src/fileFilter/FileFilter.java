
package fileFilter;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;

public class FileFilter extends Application {
    
    @Override
    public void start(Stage window) throws IOException {
        
        // link to FXML file
        Parent root = FXMLLoader.load(getClass().getResource("fileFilterUI.fxml"));
        
        Scene scene = new Scene(root, 600, 400);
        
        window.setTitle("File Filter");
        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
