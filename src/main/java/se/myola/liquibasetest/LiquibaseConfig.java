package se.myola.liquibasetest;

import javax.sql.DataSource;
import liquibase.integration.spring.SpringLiquibase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Ola Theander <ola.theander@myola.se>
 */
@Configuration
public class LiquibaseConfig {

    @Autowired
    private DataSource dataSource;

    @Bean
    public SpringLiquibase getLiquibase() {
        //Initialize Liquibase.
        final SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setDataSource(dataSource);
        liquibase.setChangeLog("liquibase.xml");
        liquibase.setShouldRun(true);

        return liquibase;
    }
}
