package ua.goit.java.dev6.hw8.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.goit.java.dev6.hw8.model.Dao.RoleDao;


import java.util.UUID;

@Repository
public interface RoleRepository extends JpaRepository<RoleDao, UUID> {
    RoleDao findByName(String name);
}
