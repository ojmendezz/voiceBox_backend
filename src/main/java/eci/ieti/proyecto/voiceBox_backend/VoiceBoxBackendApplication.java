package eci.ieti.proyecto.voiceBox_backend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"eci.ieti.proyecto.voiceBox_backend"})
public class VoiceBoxBackendApplication  implements CommandLineRunner{
	//@Autowired
    //MongoTemplate mongoTemplate;

	public static void main(String[] args) {
		SpringApplication.run(VoiceBoxBackendApplication.class, args);
	}

	@Override
    public void run(String... args) throws Exception {
		System.out.println();
	}

}
