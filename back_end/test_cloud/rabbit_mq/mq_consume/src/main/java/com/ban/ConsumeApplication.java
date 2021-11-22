package com.ban;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConsumeApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumeApplication.class, args);
    }

    @RabbitListener(queuesToDeclare = @Queue(value = "simple.queue"))
    public void rabbitSimpleListen(String message) {
        System.out.println("simple message:" + message);
    }


    @RabbitListener(queuesToDeclare = @Queue(value = "work.queue"))
    public void rabbitWorkListen1(String message) throws InterruptedException {
        System.out.println("work1 message:" + message);
        Thread.sleep(10);
    }

    @RabbitListener(queuesToDeclare = @Queue(value = "work.queue"))
    public void rabbitWorkListen2(String message) throws InterruptedException {
        System.out.println("work2 message:" + message);
        Thread.sleep(100);
    }


    // exchange
    @RabbitListener(queues = "fanout.queue1")
    public void rabbitFanoutListen1(String message) throws InterruptedException {
        System.out.println("fanout1 message:" + message);
    }

    @RabbitListener(queues = "fanout.queue2")
    public void rabbitFanoutListen2(String message) throws InterruptedException {
        System.out.println("fanout2 message:" + message);
    }


    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "direct.queue1"),
            exchange = @Exchange(value = "exc.direct", type = ExchangeTypes.DIRECT),
            key = "blue"))
    public void rabbitDirectListen1(String message) throws InterruptedException {
        System.out.println("direct1 message:" + message);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "direct.queue2"),
            exchange = @Exchange(value = "exc.direct", type = ExchangeTypes.DIRECT),
            key = "blue"))
    public void rabbitDirectListen2(String message) throws InterruptedException {
        System.out.println("direct2 message:" + message);
    }


    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "topic.queue1"),
            exchange = @Exchange(value = "exc.topic", type = ExchangeTypes.TOPIC),
            key = "#.news"))
    public void rabbitTopicListen1(String message) throws InterruptedException {
        System.out.println("topic1 message:" + message);
    }
}
