package com.prabidhi.service;

import com.prabidhi.entity.WikimediaData;
import com.prabidhi.repository.WikimediaDataRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumer {

    private WikimediaDataRepository wikimediaDataRepository;

    public KafkaConsumer(WikimediaDataRepository wikimediaDataRepository) {
        this.wikimediaDataRepository = wikimediaDataRepository;
    }

    @KafkaListener(
            topics = "wikimedia-topic",
            groupId = "my-PP-group"
    )
    public void consume(String eventMessage){
        log.info("Message received {} ", eventMessage);

        WikimediaData wikimediaData = new WikimediaData();
        wikimediaData.setWikiEventData(eventMessage);
        wikimediaDataRepository.save(wikimediaData);
    }
}
