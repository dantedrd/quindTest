package co.com.quind.transfer.config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@NoArgsConstructor
@ConfigurationProperties(prefix = "spring.datasource-postgresql")
public class DataSourcePostgresConfig {
    private String url;
    private String driverClassName;
    private String username;
    private String password;
}
