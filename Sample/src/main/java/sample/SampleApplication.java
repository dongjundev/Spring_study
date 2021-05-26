package sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SampleApplication {		// 애플리케이션을 시작할 수 있는 main 메서드가 존재하는 스프링 구성 메인 클래스

	public static void main(String[] args) {
		SpringApplication.run(SampleApplication.class, args);
	}

}
