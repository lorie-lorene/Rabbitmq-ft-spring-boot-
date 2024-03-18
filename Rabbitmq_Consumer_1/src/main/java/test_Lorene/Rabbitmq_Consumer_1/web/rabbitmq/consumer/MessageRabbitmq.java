package test_Lorene.Rabbitmq_Consumer_1.web.rabbitmq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import test_Lorene.Rabbitmq_Consumer_1.pojo.Compte;
import test_Lorene.Rabbitmq_Consumer_1.web.rabbitmq.config.QueueConfiguration;
@Slf4j
@Component
public class MessageRabbitmq {
    @RabbitListener(queues =QueueConfiguration.QUEUENOTIFICATION)

    public void lire(Compte message){
        log.info("nouvelle notification " +"{}", message);
    }
}
