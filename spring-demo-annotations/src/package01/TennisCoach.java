package package01;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
public class TennisCoach implements Coach {
	
	@Autowired
	@Qualifier("randomService")
	private FortuneService fortuneService;
	
	@Value("${foo.email}")
	private String email;

	@Value("${foo.team}")
	private String team;

	// define a default constructor
	public TennisCoach() {
		System.out.println("TennisCoach Calling default constructor");
	}
	
	// define a setter method
	/*
	@Autowired
	public void setFortuneService(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
		System.out.println("TennisCoach inside setFortuneService");
	}*/
	
	/*
	 * @Autowired 
	 * public TennisCoach(FortuneService theFortuneService){
	 * fortuneService = theFortuneService; }
	 */
	
	@PostConstruct
	public void doMyStartUpStuff() {
		System.out.println("Calling doMyStartUpStuff");
	}
	
	@PreDestroy
	public void doMyCleanUpStuff(){
		System.out.println("Calling doMyCleanUpStuff");
	}

	@Override
	public String getDailyWorkout() {
		return "Zapierdalaj";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune()+team+email;
	}

}
