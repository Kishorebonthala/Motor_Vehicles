package service;

import model.FileDetails;
import java.util.List;

public interface FileSystemBeanService {
    
    public List<FileDetails> getFiles(String path);
    public List<FileDetails> getFiles(String path, List<String> allowedMimeTypes);

}
