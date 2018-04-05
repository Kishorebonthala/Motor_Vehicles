import config.FileSystemBeanServiceConfig;
import model.FileDetails;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.FileSystemBeanService;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = FileSystemBeanServiceConfig.class)
public class DirectoryFilesScanner {

    @Autowired
    private FileSystemBeanService fileSystemBeanService;

    @Value("${SEARCH_PATH:/Users/Parimala/Desktop/Kishore/CarDetailsProject/cardetails/get-carfiles-details/src/test/resourcefiles/testdata}")
    private String searchPath;

    @Test
    public void shouldReturnAllFiles() {
        assertThat(fileSystemBeanService.getFiles(searchPath), hasSize(14));
    }

    @Test
    public void shouldReturnFileDetails() {

        boolean result = fileSystemBeanService.getFiles(searchPath).stream()
                                          .anyMatch(
                                                  fileDetails -> fileDetails.getFileName().equals("motorvehicles_03.csv")
                                                          && fileDetails.getFileMimeType().equals("text/csv")
                                                          && fileDetails.getFileSize().equals(90L)
                                                          && fileDetails.getFileExtn().equals("csv")
                                          );
        assertTrue(result);
    }

    @Test
    public void shouldRetrieveFilesBasedOnAllowableMimeTypes() {
        List<String> allowableMimeTypes = Arrays.asList("application/vnd.ms-excel", "text/csv");
        List<FileDetails> returnedFiles = fileSystemBeanService.getFiles(searchPath, allowableMimeTypes);
        assertThat(returnedFiles, hasSize(8));
    }

    @Test
    public void filesOnlyBelongToRetrievedMimeTypes() {
        List<String> allowableMimeTypes = Arrays.asList("application/vnd.ms-excel", "text/csv");
        List<FileDetails> returnedFiles = fileSystemBeanService.getFiles(searchPath, allowableMimeTypes);
        List<FileDetails> FilteredFiles = returnedFiles.stream()
                                                       .filter(fileDetails -> fileDetails.getFileMimeType().equals(
                                                               allowableMimeTypes.get(0))
                                                               || fileDetails.getFileMimeType().equals(
                                                               allowableMimeTypes.get(1)))
                                                       .collect(Collectors.toList());

        assertEquals(returnedFiles.size(), FilteredFiles.size());
    }
}
