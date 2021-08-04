package booking.backend.db;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EntityScan(basePackages = {
        "booking.backend.db.entity",
        "booking.backend.db.converter"
})
@EnableJpaRepositories(basePackages = "booking.backend.db.repository")
@EnableTransactionManagement
public class DataBaseConfiguration {
}
