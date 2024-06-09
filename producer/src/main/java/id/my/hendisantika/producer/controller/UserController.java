package id.my.hendisantika.producer.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import id.my.hendisantika.producer.dto.RegisterUserDto;
import id.my.hendisantika.producer.dto.UserRegisteredPayload;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-rabbitmq-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 6/10/24
 * Time: 06:54
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequiredArgsConstructor
public class UserController {
    static String QUEUE_NAME = "user-registration";

    private final RabbitTemplate rabbitTemplate;

    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> registerUser(@RequestBody RegisterUserDto registerUserDto) throws JsonProcessingException {
        // TODO save user in the database

        Random random = new Random();
        int confirmationCode = random.nextInt(900000) + 100000;

        UserRegisteredPayload queuePayload = new UserRegisteredPayload(
                registerUserDto.name(),
                registerUserDto.email(),
                confirmationCode
        );

        ObjectMapper objectMapper = new ObjectMapper();
        String queuePayloadString = objectMapper.writeValueAsString(queuePayload);

        rabbitTemplate.convertAndSend(QUEUE_NAME, queuePayloadString);

        Map<String, String> response = new HashMap<>();
        response.put("message", "User registered successfully!");

        return ResponseEntity.ok(response);
    }
}
