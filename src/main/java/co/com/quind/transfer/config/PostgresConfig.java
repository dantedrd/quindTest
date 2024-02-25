package co.com.quind.transfer.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@EnableConfigurationProperties(DataSourcePostgresConfig.class)
public class PostgresConfig {
    private final DataSourcePostgresConfig dataSourcePostgresConfig;

    /**
     * Constructor for {@link DataSourcePostgresConfig}, initializing it with the specified {@link DataSourcePostgresConfig}.
     *
     * @param dataSourcePostgresConfig The configuration properties for H2 DataSource.
     */
    public PostgresConfig(DataSourcePostgresConfig dataSourcePostgresConfig) {
        this.dataSourcePostgresConfig = dataSourcePostgresConfig;
    }

    /**
     * Creates and configures a {@link DataSource} bean for the H2 database.
     * The {@link DataSource} is configured based on the properties provided in {@link DataSourcePostgresConfig}.
     *
     * @return Configured {@link DataSource} instance for the H2 database.
     */
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(dataSourcePostgresConfig.getDriverClassName());
        dataSource.setUrl(dataSourcePostgresConfig.getUrl());
        dataSource.setUsername(dataSourcePostgresConfig.getUsername());
        dataSource.setPassword(dataSourcePostgresConfig.getPassword());
        return dataSource;
    }
}
