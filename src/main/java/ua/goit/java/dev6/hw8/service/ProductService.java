package ua.goit.java.dev6.hw8.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ua.goit.java.dev6.hw8.model.Dto.ProductDto;
import ua.goit.java.dev6.hw8.repository.ProductRepository;


import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductConverter productConverter;
    private final ProductRepository productRepository;

    public List<ProductDto> findAll() {
        return productRepository.findAll(Sort.by("name"))
                .stream()
                .map(productConverter::mapToDto)
                .collect(Collectors.toList());
    }

    public ProductDto get(UUID id) {
        return productRepository.findById(id)
                .map(productConverter::mapToDto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public UUID create(ProductDto productDto) {
        return productRepository.save(productConverter.mapToDao(productDto)).getId();
    }

    public void update(UUID id, ProductDto productDto) {
        productDto.setId(id);
        productRepository.findById(id)
                .map((p)->productRepository.save(productConverter.mapToDao(productDto)))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public void delete(UUID id){
        productRepository.deleteById(id);
    }
}
