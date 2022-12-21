package ua.goit.java.dev6.hw8.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.goit.java.dev6.hw8.model.Dao.ProducerDao;

import java.util.UUID;

public interface ProducerRepository extends JpaRepository<ProducerDao, UUID> {
}
