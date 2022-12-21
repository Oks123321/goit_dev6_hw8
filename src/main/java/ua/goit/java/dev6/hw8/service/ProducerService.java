package ua.goit.java.dev6.hw8.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ua.goit.java.dev6.hw8.model.Dto.ProducerDto;
import ua.goit.java.dev6.hw8.repository.ProducerRepository;


import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProducerService {
    private final ProducerConverter producerConverter;
    private final ProducerRepository producerRepository;

    public List<ProducerDto> findAll() {
        return producerRepository.findAll(Sort.by("name"))
                .stream()
                .map(producerConverter::mapToDto)
                .collect(Collectors.toList());
    }

    public ProducerDto get(UUID id) {
        return producerRepository.findById(id)
                .map(producerConverter::mapToDto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public UUID create(ProducerDto producerDto) {
        return producerRepository.save(producerConverter.mapToDao(producerDto)).getId();
    }

    public void update(UUID id, ProducerDto producerDto) {
        producerDto.setId(id);
        producerRepository.findById(id)
                .map((p)->producerRepository.save(producerConverter.mapToDao(producerDto)))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    }

    public void delete(UUID id) {
        producerRepository.deleteById(id);
    }


}
