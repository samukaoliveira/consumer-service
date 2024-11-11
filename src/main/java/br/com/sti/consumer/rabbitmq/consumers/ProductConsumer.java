package br.com.sti.consumer.rabbitmq.consumers;

import br.com.sti.commons.dtos.ProductDTO;
import lombok.extern.log4j.Log4j2;
import lombok.val;

import java.io.IOException;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;


@Log4j2
@Component
public class ProductConsumer {

    @RabbitListener(queues = "product.log")
    public void consumer(byte[] message){
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            ProductDTO product = objectMapper.readValue(message, ProductDTO.class);
            // Agora você pode trabalhar com o objeto product
            log.info("Consumindo para log " + product.toString());
        } catch (IOException e) {
            // Tratar erro de desserialização
            e.printStackTrace();
        };
    }

}
