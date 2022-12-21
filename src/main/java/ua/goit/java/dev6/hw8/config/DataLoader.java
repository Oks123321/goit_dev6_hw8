package ua.goit.java.dev6.hw8.config;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import ua.goit.java.dev6.hw8.model.Dao.RoleDao;
import ua.goit.java.dev6.hw8.repository.RoleRepository;


//@Component
@AllArgsConstructor
public class DataLoader {
    private final RoleRepository roleRepository;

    @PostConstruct
    private void loadData(){
        roleRepository.deleteAll();
        RoleDao user = new RoleDao();
        user.setName("ROLE_USER");
        roleRepository.save(user);
        RoleDao admin = new RoleDao();
        admin.setName("ROLE_ADMIN");
        roleRepository.save(admin);

    }
}
