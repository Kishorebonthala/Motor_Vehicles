package config;

import com.scenarios.helpers.ParseCSVFiles;
import com.scenarios.helpers.ParserFile;
import cucumber.runtime.java.spring.ScenarioScoped;
import cucumber.runtime.java.spring.ScenarioScoper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import java.nio.file.FileSystems;
import java.nio.file.Path;


@Configuration
@Import({ FileSystemBeanServiceConfig.class, ScenarioScoper.class})
public class BddConfiguration {

    @Bean @ScenarioScoped
    public State state() {
        return new State();
    }

    @Bean
    public ParserFile parserFile(){
        return new ParseCSVFiles();
    }

    @Bean
    public WebDriver driver(){
        System.setProperty("webdriver.gecko.driver","/Users/Parimala/Desktop/Kishore/CarDetailsProject/cardetails/scenarios/src/main/resources/drivers/geckodriver.exe");
        return new FirefoxDriver();
    }

}
