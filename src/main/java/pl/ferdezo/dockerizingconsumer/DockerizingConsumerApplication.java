package pl.ferdezo.dockerizingconsumer;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class DockerizingConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(DockerizingConsumerApplication.class, args);
    }
}
