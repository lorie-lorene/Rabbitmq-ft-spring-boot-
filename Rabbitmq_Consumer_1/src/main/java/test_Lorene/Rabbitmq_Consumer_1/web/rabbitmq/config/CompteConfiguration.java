package test_Lorene.Rabbitmq_Consumer_1.web.rabbitmq.config;


import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Declarables;
import org.springframework.amqp.core.FanoutExchange;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class CompteConfiguration{
     public static final String EXCHANGE = "notification-exchange";
    public static final String QUEUE="Notification-Queue";
    
   @Bean
    Queue createQueue(){
        return new Queue(QUEUE);
    }
    // @Bean
    // public MessageConverter converter()
    // {
    //     return new Jackson2JsonMessageConverter();
    // }

   
    @Bean
    public AmqpTemplate template(ConnectionFactory connectionFactory)
    {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }


    @Bean
    public FanoutExchange topicExchange()
    {
        return  new FanoutExchange(EXCHANGE);
    }


     @Bean
    Binding binding(FanoutExchange topicExchange, Queue queueRapportTontine){
        return  BindingBuilder.bind(queueRapportTontine).to(topicExchange);
    }
    // public Declarables fanoutExchangeBindings(FanoutExchange topicExchange, Queue queueRapportTontine)
    // {
    //     return new Declarables(
    //             BindingBuilder.bind(queueRapportTontine).to(topicExchange);


    //     );
    
    @Bean
    public MessageConverter jsonMessageConverter(){
        ObjectMapper objectMapper= new ObjectMapper();
        return new Jackson2JsonMessageConverter(objectMapper);
    }

}