package ua.goit.java.dev6.hw8.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.goit.java.dev6.hw8.model.Dao.ProductDao;


import java.util.UUID;

public interface ProductRepository extends JpaRepository<ProductDao, UUID> {
}
