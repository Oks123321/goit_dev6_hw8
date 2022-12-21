package ua.goit.java.dev6.hw8.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ua.goit.java.dev6.hw8.model.Dto.UserDto;
import ua.goit.java.dev6.hw8.repository.UserRepository;


import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserConverter userConverter;
    public List<UserDto> findAll() {
        return userRepository.findAll(Sort.by("email"))
                .stream()
                .map(userConverter::mapToDto)
                .collect(Collectors.toList());
    }

    public UserDto get(UUID id) {
        return userRepository.findById(id)
                .map(userConverter::mapToDto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public UUID create(UserDto userDto) {
        return userRepository.save(userConverter.mapToDao(userDto)).getId();
    }

    public void update(UUID id, UserDto userDto) {
        userDto.setId(id);
        userRepository.findById(id)
                .map((p)->userRepository.save(userConverter.mapToDao(userDto)))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public void delete(UUID id){
        userRepository.deleteById(id);
    }
    public UserDto findByUsername(String username){
        return userRepository.findByEmail(username)
                .map(userConverter::mapToDto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
    public boolean isExistEmail(String email){
        return userRepository.existsByEmail(email);
    }
}
