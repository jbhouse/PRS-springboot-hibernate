package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages= {
		"repositories", "entities", "controllers"
})
public class Application {
	// this is the main method we want to run
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}