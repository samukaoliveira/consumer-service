package br.com.sti.consumer.rabbitmq.consumers;

import br.com.sti.commons.dtos.ProductDTO;
import lombok.extern.log4j.Log4j2;
import lombok.val;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Log4j2
@Component
public class StringConsumer {

    // @Scheduled(fixedDelay = 5000)
    // @RabbitListener(queues = "product.log")
    public void consumer(String message){
        val product = new ProductDTO();
        log.info("Consumindo para log " + message);
    }

    // @Scheduled(fixedDelay = 8000)
    // @RabbitListener(queues = "product.log")
    public void consumerPdf(String message){
        log.info("Consumindo para PDF " + message);
    }

    // @Scheduled(fixedDelay = 11000)
    // @RabbitListener(queues = "product.log")
    public void consumerMP3(String message){
        log.info("Consumindo para MP3 " + message);
    }
}
