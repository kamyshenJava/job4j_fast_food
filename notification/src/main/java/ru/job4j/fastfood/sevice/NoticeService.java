package ru.job4j.fastfood.sevice;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.job4j.fastfood.model.Notice;
import ru.job4j.fastfood.model.Order;
import ru.job4j.fastfood.repository.NoticeRepository;

@Service
public class NoticeService {
    private final NoticeRepository noticeRepository;

    public NoticeService(NoticeRepository noticeRepository) {
        this.noticeRepository = noticeRepository;
    }

    @KafkaListener(topics = {"messengers"})
    public void saveNotice(ConsumerRecord<Integer, Order> input) {
        Notice notice = new Notice();
        Order order = input.value();
        notice.setBody(String.format("The order %s has been placed", order.toString()));
        noticeRepository.save(notice);
    }
}
