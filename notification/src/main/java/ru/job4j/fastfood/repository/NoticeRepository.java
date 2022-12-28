package ru.job4j.fastfood.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.job4j.fastfood.model.Notice;

@Repository
public interface NoticeRepository extends JpaRepository<Notice, Integer> {
}
