package br.com.sti.consumer.rabbitmq.config;

import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.sti.consumer.rabbitmq.consumers.ProductConsumer;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Jackson2JsonMessageConverter jacksonMessageConverter() {
        return new Jackson2JsonMessageConverter(); // Usando o Jackson para conversão JSON
    }

    @Bean
    public SimpleMessageListenerContainer messageListenerContainer(ConnectionFactory connectionFactory, MessageListenerAdapter messageListenerAdapter) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames("product.log"); // Nome da fila

        // Define o listener adaptado com o conversor
        container.setMessageListener(messageListenerAdapter);
        return container;
    }

    @Bean
    public MessageListenerAdapter messageListenerAdapter(ProductConsumer productConsumer) {
        // Adapte o listener para utilizar o conversor
        return new MessageListenerAdapter(productConsumer, "consumer");
    }
    
}
