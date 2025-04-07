package university.innopolis.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app", ignoreUnknownFields = false)
public record ApplicationConfiguration() {
}
