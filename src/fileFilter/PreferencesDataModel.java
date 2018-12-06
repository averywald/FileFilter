
// PreferencesDataModel.java

package preferences;

import java.util.prefs.Preferences;

/**
 * Model holding data and states for program preferences
 *
 * @author averywald
 */
public class PreferencesDataModel {
    
    private Boolean cleanUnused;
    private Boolean replaceDuplicates;  // StandardCopyOption
    private Boolean deleteEmptyFolders;
    
    // methods -----------------------------------------------------------------
    
    // constructor
    void PreferencesDataModel() {
        // create Preferences node to store user settings within
        Preferences pref = Preferences.userNodeForPackage(PreferencesDataModel.class);
        // set up states and variables
        cleanUnused = false;
        replaceDuplicates = false;
        deleteEmptyFolders = false;
    }
    
    // getters
    public Boolean getCleanUnused() {
        return this.cleanUnused;
    }
    public Boolean getReplaceDuplicates() {
        return this.replaceDuplicates;
    }
    public Boolean getDeleteEmptyFolders() {
        return this.deleteEmptyFolders;
    }
    
    // setters
    public void setCleanUnused(Boolean state) {
        this.cleanUnused = state;
    }
    public void setReplaceDuplicates(Boolean state) {
        this.replaceDuplicates = state;
    }
    public void setDeleteEmptyFolders(Boolean state) {
        this.deleteEmptyFolders = state;
    }
    
}
