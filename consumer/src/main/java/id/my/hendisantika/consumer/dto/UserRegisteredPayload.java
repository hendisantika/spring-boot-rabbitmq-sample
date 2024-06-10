package id.my.hendisantika.consumer.dto;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-rabbitmq-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 6/10/24
 * Time: 07:00
 * To change this template use File | Settings | File Templates.
 */
public record UserRegisteredPayload(String fullName, String emailAddress, int confirmationCode) {
}
