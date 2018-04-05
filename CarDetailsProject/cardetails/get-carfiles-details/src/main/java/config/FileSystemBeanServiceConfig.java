package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import service.FileSystemBeanService;
import service.FileSystemBeanServiceExecution;

@Configuration
public class FileSystemBeanServiceConfig {

    @Bean
    public FileSystemBeanService fileSystemBeanService() {
        return new FileSystemBeanServiceExecution();
    }
}
