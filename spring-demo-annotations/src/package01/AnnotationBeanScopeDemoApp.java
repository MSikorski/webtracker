package package01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {

		// read spring config file
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(JavaConfig.class);

		// get the bean from the container file
		SwimCoach theCoach = context.getBean("swimCoach", SwimCoach.class);
		SwimCoach alphaCoach = context.getBean("swimCoach", SwimCoach.class);
		
		// call a method on the bean
		boolean result = (theCoach == alphaCoach);
		System.out.println(theCoach.getDailyFortune());
		System.out.println(theCoach.getEmial());
		
		// close the context
		context.close();
	}

}
