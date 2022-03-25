package br.com.lpr.ms.email.adapters.configuration.dev;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("dev")
@Configuration
public class DatabaseConfigDev {
	
	@Bean
	public DataSource getDataSource() {
		DataSourceBuilder<?>  dataSourceBuilder = DataSourceBuilder.create();
		dataSourceBuilder.driverClassName("org.postgresql.Driver");
		dataSourceBuilder.url("jdbc:postgresql://localhost:5433/msemail");
		dataSourceBuilder.username("postgres");
		dataSourceBuilder.password("fkldfkdl@#498");
		return dataSourceBuilder.build();
	}
	
	
}
