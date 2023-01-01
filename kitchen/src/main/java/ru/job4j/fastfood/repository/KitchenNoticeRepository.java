package ru.job4j.fastfood.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.job4j.fastfood.model.KitchenNotice;

@Repository
public interface KitchenNoticeRepository extends JpaRepository<KitchenNotice, Integer> {
}
