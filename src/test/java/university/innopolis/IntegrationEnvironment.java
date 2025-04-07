package university.innopolis;

import jakarta.validation.constraints.NotNull;
import org.flywaydb.core.Flyway;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.JdbcDatabaseContainer;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
public abstract class IntegrationEnvironment {
    public static final PostgreSQLContainer<?> POSTGRES;

    static {
        POSTGRES = new PostgreSQLContainer<>("postgres:15")
            .withDatabaseName("event_planner")
            .withUsername("postgres")
            .withPassword("postgres");
        POSTGRES.start();

        runMigrations(POSTGRES);
    }

    private static void runMigrations(@NotNull JdbcDatabaseContainer<?> c) {
        var migrationSucceeded = Flyway.configure()
            .dataSource(c.getJdbcUrl(), c.getUsername(), c.getPassword())
            .locations("filesystem:db/migration")
            .failOnMissingLocations(true)
            .load()
            .migrate().migrations;

        System.out.println("The number of migrations that are succeeded: " + migrationSucceeded.size());
    }

    @DynamicPropertySource
    private static void dynamicPropertySources(@NotNull DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", POSTGRES::getJdbcUrl);
        registry.add("spring.datasource.username", POSTGRES::getUsername);
        registry.add("spring.datasource.password", POSTGRES::getPassword);
    }
}
