package ua.goit.java.dev6.hw8.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.goit.java.dev6.hw8.model.Dao.UserDao;


import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<UserDao, UUID> {
    Optional<UserDao> findByEmail(String email);
    boolean existsByEmail(String email);
}
