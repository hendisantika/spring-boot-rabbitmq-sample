package id.my.hendisantika.consumer.listener;

import id.my.hendisantika.consumer.dto.UserRegisteredPayload;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import tools.jackson.databind.json.JsonMapper;

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
@RequiredArgsConstructor
public class UserRegisteredListener {

    private final JsonMapper jsonMapper;

    public void onMessageReceived(String message) {
        UserRegisteredPayload payload = jsonMapper.readValue(message, UserRegisteredPayload.class);

        System.out.println("Message received");
        System.out.println("User full name:    " + payload.fullName());
        System.out.println("Email Address:     " + payload.emailAddress());
        System.out.println("Confirmation code: " + payload.confirmationCode());

        // TODO send an email using the data
    }
}
