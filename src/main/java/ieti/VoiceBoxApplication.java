package ieti;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ieti.voicebox.service.UserService;


@SpringBootApplication
public class VoiceBoxApplication  {
	@Autowired
	UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(VoiceBoxApplication.class, args);
	}
}
