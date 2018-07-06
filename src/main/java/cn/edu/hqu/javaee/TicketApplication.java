package cn.edu.hqu.javaee;

import java.io.File;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages="cn.edu.hqu.javaee.chapter4_4.repository")
public class TicketApplication {
	public static final String ROOT = "D:\\upload-dir";
	public static void main(String[] args) {
		File file = new File(ROOT);
		if (!file.exists()) {
			file.mkdir();
		}
		SpringApplication.run(TicketApplication.class, args);
	}
}
