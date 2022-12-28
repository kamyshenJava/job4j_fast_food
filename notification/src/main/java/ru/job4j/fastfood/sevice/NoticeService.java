package ru.job4j.fastfood.sevice;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.job4j.fastfood.model.Notice;
import ru.job4j.fastfood.repository.NoticeRepository;

@Service
public class NoticeService {
    private final NoticeRepository noticeRepository;

    public NoticeService(NoticeRepository noticeRepository) {
        this.noticeRepository = noticeRepository;
    }

    @KafkaListener(topics = {"messengers"})
    public void saveNotice(ConsumerRecord<Integer, String> input) {
        Notice notice = new Notice();
        notice.setBody(input.value());
        noticeRepository.save(notice);
    }
}
