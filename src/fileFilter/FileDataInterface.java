
// FileDataInterface.java

package fileFilter;

import java.io.File;
import java.io.IOException;

public interface FileDataInterface {
    
    public Boolean isExecutable(File f);
    
    public Boolean isInParentDirectory(String parentDirectory);
    
    public String getDirName(File f) throws IOException;
    
    // getCleaningScope()
    
    // setCleaningScope()
    
}
