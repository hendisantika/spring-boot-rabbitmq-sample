package id.my.hendisantika.consumer.listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

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
@Component
public class UserRegisteredListener {
    public void onMessageReceived(String message) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        TypeReference<UserRegisteredPayload> mapType = new TypeReference<>() {
        };
        UserRegisteredPayload payload = objectMapper.readValue(message, mapType);

        System.out.println("Message received");
        System.out.println("User full name:    " + payload.fullName());
        System.out.println("Email Address:     " + payload.emailAddress());
        System.out.println("Confirmation code: " + payload.confirmationCode());

        // TODO send an email using the data
    }
}
