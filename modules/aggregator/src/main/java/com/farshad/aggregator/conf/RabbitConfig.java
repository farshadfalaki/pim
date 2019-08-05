package com.farshad.aggregator.conf;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;

@Configuration
@EnableRabbit
public class RabbitConfig implements RabbitListenerConfigurer {
    String productQueueName = QueueConstants.PRODUCT_QUEUE_NAME;
    String statQueueName = QueueConstants.STAT_QUEUE_NAME;

    @Bean(value = "productQueue")
    Queue productQueue() {
        return QueueBuilder.durable(productQueueName)
                .withArgument("x-message-ttl", 3 * 60 * 60 * 1000L)
                .withArgument("x-dead-letter-exchange", "")
                .withArgument("x-dead-letter-routing-key", "DLQ." + productQueueName)
                .build();
    }

    @Bean
    Queue productDeadLetterQueue() {
        return QueueBuilder
                .durable("DLQ." + productQueueName)
                .withArgument("x-message-ttl", 24 * 60 * 60 * 1000L).build();
    }

    @Bean(value = "productExchange")
    DirectExchange productExchange() {
        return new DirectExchange(productQueueName + ".exchange", true, false);
    }


    @Bean(value = "productBinding")
    Binding productBinding(@Qualifier("productQueue") Queue queue,
                           @Qualifier("productExchange") DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(productQueueName);
    }


    @Bean(value = "statQueue")
    Queue statQueue() {
        return QueueBuilder.durable(statQueueName)
                .withArgument("x-message-ttl", 3 * 60 * 60 * 1000L)
                .withArgument("x-dead-letter-exchange", "")
                .withArgument("x-dead-letter-routing-key", "DLQ." + statQueueName)
                .build();
    }

    @Bean
    Queue statDeadLetterQueue() {
        return QueueBuilder
                .durable("DLQ." + statQueueName)
                .withArgument("x-message-ttl", 24 * 60 * 60 * 1000L).build();
    }

    @Bean(value = "statExchange")
    DirectExchange statExchange() {
        return new DirectExchange(statQueueName + ".exchange", true, false);
    }


    @Bean(value = "statBinding")
    Binding statBinding(@Qualifier("statQueue") Queue queue,
                           @Qualifier("statExchange") DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(statQueueName);
    }


    @Bean
    public Jackson2JsonMessageConverter jackson2MessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    public MappingJackson2MessageConverter consumerJackson2MessageConverter() {
        return new MappingJackson2MessageConverter();
    }


    @Bean
    public DefaultMessageHandlerMethodFactory messageHandlerMethodFactory() {
        DefaultMessageHandlerMethodFactory factory = new DefaultMessageHandlerMethodFactory();
        factory.setMessageConverter(consumerJackson2MessageConverter());
        return factory;
    }

    @Override
    public void configureRabbitListeners(final RabbitListenerEndpointRegistrar registrar) {
        registrar.setMessageHandlerMethodFactory(messageHandlerMethodFactory());
    }
}
