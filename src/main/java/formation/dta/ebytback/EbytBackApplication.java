package formation.dta.ebytback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = { "formation.dta.ebytback" })
@EnableJpaAuditing
@EnableJpaRepositories(basePackages = { "formation.dta.ebytback" })
@EntityScan(basePackages = { "formation.dta.ebytback" })
public class EbytBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(EbytBackApplication.class, args);
		System.out.println("Coucou");
	}
}
