package mx.com.leonrv.testfirebase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude =  {DataSourceAutoConfiguration.class })
public class TestFirebaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestFirebaseApplication.class, args);
	}

}
