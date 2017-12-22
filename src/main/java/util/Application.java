package util;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages= {
		"domain", "web"
})
public class Application {
	// this is the main method we want to run
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}