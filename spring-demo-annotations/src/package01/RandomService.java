package package01;

import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RandomService implements FortuneService {
	
	private String data[]={"1",
			"2",
			"3"
	};

	@PostConstruct
	private void wczytajDane(){
		System.out.println("Wczytywanie danych");
	}
	
	private Random random = new Random();
	
	@Override
	public String getFortune() {
		return data[random.nextInt(data.length)];
	}

}
