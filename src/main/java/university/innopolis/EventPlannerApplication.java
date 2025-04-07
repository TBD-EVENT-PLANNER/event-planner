package university.innopolis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import university.innopolis.configuration.ApplicationConfiguration;

@SpringBootApplication
@EnableConfigurationProperties(ApplicationConfiguration.class)
public class EventPlannerApplication {
    public static void main(String[] args) {
        SpringApplication.run(EventPlannerApplication.class, args);
    }
}
