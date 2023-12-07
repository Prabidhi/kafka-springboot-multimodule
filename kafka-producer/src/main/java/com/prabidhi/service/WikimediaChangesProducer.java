package com.prabidhi.service;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;
import com.prabidhi.handler.WikimediaChangeshandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.ConsumerGroupListing;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class WikimediaChangesProducer {

    private KafkaTemplate<String, Object> kafkaTemplate;

    public WikimediaChangesProducer(KafkaTemplate<String, Object> kafkaTemplate) { //constructor injection
        this.kafkaTemplate = kafkaTemplate;
    }


    //method to read realtime wikimedia
    public void sendMessage() throws InterruptedException {
        String topic = "wikimedia-topic";

        // to read real time stream data, we use event source
        // need a couple of libraries
        // 1. OkHttp event source-> com.launchdarkly
        // 2. OkHttp squareup
        // 3. fasterxml.jackson
        // 4. jackson databind
        
        // Create a class to handle wikimedia change handler
        EventHandler eventHandler = new WikimediaChangeshandler(kafkaTemplate, topic);
        String url = "https://stream.wikimedia.org/v2/stream/recentchange";
        EventSource.Builder builder = new EventSource.Builder(eventHandler, URI.create(url));
        EventSource eventSource = builder.build();
        eventSource.start();

        TimeUnit.MINUTES.sleep(10);




    }






}
