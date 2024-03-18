package test_Lorene.Rabbitmq_Consumer_1.web.rabbitmq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class QueueConfiguration {


    public static final String QUEUENOTIFICATION= "Notification-Queue";


    //pour fournir les donnes pour un rapport de tontine
    @Bean
    public Queue queueRapportTontine()
    {
        return  new Queue(QUEUENOTIFICATION);
    }
}
