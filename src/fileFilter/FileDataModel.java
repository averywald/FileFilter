
// FileFilterModel.java

package fileFilter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

/**
 * Model holding file/directory data and states
 *
 * @author averywald
 */
public class FileDataModel implements FileDataInterface {
    
    // source
    File sourceFile;
    Path sourcePath;
    String sourceFileName;
   
    // target
    File targetFile;
    Path targetPath;
    String targetFileName;
    
    // files in directory
    File[] dirFiles;
    
    // methods -----------------------------------------------------------------
    
    // check if file is executable
    // if not, delete???
    @Override
    public Boolean isExecutable(File f) {
        return f.canExecute();
    }
    @Override
    public Boolean isInParentDirectory(String parentDirectory) {
        return sourceFile.getParent().equals(parentDirectory);
    }
    
    // getters
    
    // getFileType()
    
    @Override
    public String getDirName(File f) throws IOException {
        String result;
        if (f.isDirectory() == false) {
            result = "Not a directory";
        }
        result = f.getCanonicalPath();
        return result;
    }
    
    // getCleaningScope()
    
    // setCleaningScope()
    
    
}