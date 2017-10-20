package package01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("package01")
@PropertySource("classpath:sport.properties")

public class JavaConfig {

	@Bean
	public FortuneService sadFortuneService() {
		return new SadFortuneService();
	}
	
	@Bean Coach swimCoach() {
		return new SwimCoach(sadFortuneService());
	}
}
