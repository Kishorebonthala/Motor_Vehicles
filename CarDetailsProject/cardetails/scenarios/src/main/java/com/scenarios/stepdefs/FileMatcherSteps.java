package com.scenarios.stepdefs;

import config.DriverConfiguration;
import config.State;
import cucumber.api.java8.En;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import service.FileSystemBeanService;
import java.util.Arrays;
import java.util.List;

@ContextConfiguration(classes = DriverConfiguration.class)
public class FileMatcherSteps implements En {

    @Autowired
    private FileSystemBeanService fileSystemBeanService;

    @Autowired
    private State state;

    public FileMatcherSteps() {

        Given("^I use fileSystemBean service on available csv files from \"([^\"]*)\"$",
              (String dirPath) -> {
                  List<String> allowableMimeTypes = Arrays.asList("text/csv");
                  state.fileDetailsList = fileSystemBeanService.getFiles(dirPath,allowableMimeTypes);
                  state.searchPath = dirPath;
              }
        );

    }

}
