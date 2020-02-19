package pl.ferdezo.dockerizingconsumer;

import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class MessageConsumer {

    @RabbitListener(queues = "discount")
    public void consume(String message) {
        log.info("Message received: {}", message);
    }
}
