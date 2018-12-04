package pl.sda.jdbc.jdbc.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.web.bind.annotation.ControllerAdvice;

import javax.sql.DataSource;

@Configuration
@ComponentScan("pl.sda.jdbc")
public class JdbcConfig {
    @Bean
    public DataSource dataSource(){
        return new EmbeddedDatabaseBuilder()
        .setType(EmbeddedDatabaseType.H2)
        .addScript("db/create-db.sql")
        .addScript("db/insert-db.sql")
        .build();

    }

    @Primary
    @Bean
    public JdbcTemplate jdbcTemplate (DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
}
