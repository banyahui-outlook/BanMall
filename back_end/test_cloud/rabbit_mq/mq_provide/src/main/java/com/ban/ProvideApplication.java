package com.ban;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProvideApplication implements ApplicationRunner {
    public static void main(String[] args) {
        SpringApplication.run(ProvideApplication.class, args);
    }

    @Autowired
    private RabbitTemplate rabbitTemplate;

    //simple
    @Bean
    public Queue simpleQueue() {
        final boolean isDurable = true;
        final boolean isExclusive = false;
        final boolean autoDelete = false;
        return new org.springframework.amqp.core.Queue("simple.queue", isDurable, isExclusive, autoDelete);
    }

    //work
    @Bean
    public Queue workQueue() {
        final boolean isDurable = true;
        final boolean isExclusive = false;
        final boolean autoDelete = false;
        return new org.springframework.amqp.core.Queue("work.queue", isDurable, isExclusive, autoDelete);
    }

    //fanout
    @Bean
    public FanoutExchange buildFanoutExchange() {
        final boolean isDurable = true;
        final boolean autoDelete = false;
        return new FanoutExchange("exc.fanout", isDurable, autoDelete);
    }

    @Bean
    public Queue fanoutQueue1() {
        final boolean isDurable = true;
        final boolean isExclusive = false;
        final boolean autoDelete = false;
        return new org.springframework.amqp.core.Queue("fanout.queue1", isDurable, isExclusive, autoDelete);
    }

    @Bean
    public Queue fanoutQueue2() {
        final boolean isDurable = true;
        final boolean isExclusive = false;
        final boolean autoDelete = false;
        return new org.springframework.amqp.core.Queue("fanout.queue2", isDurable, isExclusive, autoDelete);
    }

    @Bean
    public Binding buildFanout1Binding() {
        return new Binding("fanout.queue1",
                Binding.DestinationType.QUEUE, "exc.fanout", "", null);
    }

    @Bean
    public Binding buildFanout2Binding() {
        return new Binding("fanout.queue2",
                Binding.DestinationType.QUEUE, "exc.fanout", "", null);
    }

    // direct
    @Bean
    public DirectExchange buildDirectExchange() {
        final boolean isDurable = true;
        final boolean autoDelete = false;
        return new DirectExchange("exc.direct", isDurable, autoDelete);
    }

    @Bean
    public Queue directQueue1() {
        final boolean isDurable = true;
        final boolean isExclusive = false;
        final boolean autoDelete = false;
        return new org.springframework.amqp.core.Queue("direct.queue1", isDurable, isExclusive, autoDelete);
    }

    @Bean
    public Queue directQueue2() {
        final boolean isDurable = true;
        final boolean isExclusive = false;
        final boolean autoDelete = false;
        return new org.springframework.amqp.core.Queue("direct.queue2", isDurable, isExclusive, autoDelete);
    }

    @Bean
    public Binding buildDirect1Binding() {
        return BindingBuilder.bind(directQueue1()).to(buildDirectExchange()).with("blue");
    }

    @Bean
    public Binding buildDirect1Binding2() {
        return BindingBuilder.bind(directQueue1()).to(buildDirectExchange()).with("red");
    }

    @Bean
    public Binding buildDirect2Binding() {
        return BindingBuilder.bind(directQueue2()).to(buildDirectExchange()).with("blue");
    }

    @Bean
    public Binding buildDirect2Binding2() {
        return BindingBuilder.bind(directQueue2()).to(buildDirectExchange()).with("yellow");
    }

    // topic
    @Bean
    public TopicExchange buildTopicExchange() {
        final boolean isDurable = true;
        final boolean autoDelete = false;
        return new TopicExchange("exc.topic", isDurable, autoDelete);
    }

    @Bean
    public Queue topicQueue1() {
        final boolean isDurable = true;
        final boolean isExclusive = false;
        final boolean autoDelete = false;
        return new org.springframework.amqp.core.Queue("topic.queue1", isDurable, isExclusive, autoDelete);
    }

    @Bean
    public Queue topicQueue2() {
        final boolean isDurable = true;
        final boolean isExclusive = false;
        final boolean autoDelete = false;
        return new org.springframework.amqp.core.Queue("topic.queue2", isDurable, isExclusive, autoDelete);
    }

    @Bean
    public Binding buildTopic1Binding() {
        return BindingBuilder.bind(topicQueue1()).to(buildTopicExchange()).with("china.news");
    }

    @Bean
    public Binding buildTopic1Binding2() {
        return BindingBuilder.bind(topicQueue1()).to(buildTopicExchange()).with("china.weather");
    }

    @Bean
    public Binding buildTopic2Binding() {
        return BindingBuilder.bind(topicQueue2()).to(buildTopicExchange()).with("japan.news");
    }

    @Bean
    public Binding buildTopic2Binding2() {
        return BindingBuilder.bind(topicQueue2()).to(buildTopicExchange()).with("japan.weather");
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
////   simple send
//        String simpleQueueName = "simple.queue";
//        String simpleMessage = "hello, simple amqp!";
//        rabbitTemplate.convertAndSend(simpleQueueName, simpleMessage);

////   work send
//        String workQueueName = "work.queue";
//        for (int i = 0; i < 9; i++) {
//            String workMessage = "hello, work amqp:" + i;
//            rabbitTemplate.convertAndSend(workQueueName, workMessage);
//        }


////  fanout send
//        String exchangeName = "exc.fanout";
//        String fanoutMessage = "hello, fanout amqp!";
//        rabbitTemplate.convertAndSend(exchangeName, "", fanoutMessage);

////        direct send
//        String exchangeName = "exc.direct";
//        String directMessage = "hello, yellow!";
//        rabbitTemplate.convertAndSend(exchangeName, "yellow", directMessage);

        //   topic send
        String exchangeName = "exc.topic";
        String topicMessage = "hello, china news!";
        rabbitTemplate.convertAndSend(exchangeName, "china.news", topicMessage);
        String topic2Message = "hello, china weather!";
        rabbitTemplate.convertAndSend(exchangeName, "china.weather", topic2Message);
    }
}
