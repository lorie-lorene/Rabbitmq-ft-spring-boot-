package Lorene.Rabbitmq.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import Lorene.Rabbitmq.pojo.Compte;
import lombok.AllArgsConstructor;
@AllArgsConstructor
@Component
public class RabbitmqService {
    
    private RabbitTemplate template ;
    public void publier(Compte compte){
        this.template.convertAndSend(compte);
        
    }
}
