package com.example.demo.hlldu.impala;

import com.cloudera.impala.jdbc41.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class ImpalaConfig {

    @Value("${impala.url}")
    private String impalaUrl;
    @Value("${impala.port}")
    private String impalaPort;
    @Value("${impala.schema}")
    private String impalaScheme;
    @Value("${impala.user}")
    private String impalaUser;
    @Value("${impala.password}")
    private String impalaPassword;

    @Bean(name = {"impalaJdbcTemplate"})
    public JdbcTemplate getImpalaJdbcTemplate() {
        String connUrl = this.impalaUrl + ":" + this.impalaPort + "/" + this.impalaScheme + ";auth=noSasl";
        DataSource dataSource = new DataSource();
        dataSource.setURL(connUrl);
        return new JdbcTemplate(dataSource);
    }
}
