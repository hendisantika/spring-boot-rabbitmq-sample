package id.my.hendisantika.consumer.config;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-rabbitmq-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 6/10/24
 * Time: 06:59
 * To change this template use File | Settings | File Templates.
 */
@Configuration
public class RabbitMQConfig {
    @Bean
    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory, MessageListenerAdapter listenerAdapter) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();

        container.setConnectionFactory(connectionFactory);
        container.setMessageListener(listenerAdapter);

        container.setQueueNames("user-registration");

        return container;
    }

    @Bean
    MessageListenerAdapter listenerAdapter(UserRegisteredListener listener) {
        return new MessageListenerAdapter(listener, "onMessageReceived");
    }
}
