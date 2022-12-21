package ua.goit.java.dev6.hw8.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ua.goit.java.dev6.hw8.model.Dao.RoleDao;
import ua.goit.java.dev6.hw8.repository.RoleRepository;


import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;
    public List<RoleDao> findAll(){
        return roleRepository.findAll();
    }
    public RoleDao findById(UUID id){
        return roleRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
    public boolean idFound(UUID id){
        return roleRepository.existsById(id);
    }
    public RoleDao findByName(String name){
        return roleRepository.findByName(name);
    }


}
