package ua.goit.java.dev6.hw8.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.goit.java.dev6.hw8.model.Dao.ProductDao;
import ua.goit.java.dev6.hw8.model.Dto.ProductDto;


@Service
@RequiredArgsConstructor
public class ProductConverter {
    private final ProducerConverter producerConverter;

    public ProductDto mapToDto(final ProductDao productDao) {
        ProductDto productDto = new ProductDto();
        productDto.setId(productDao.getId());
        productDto.setName(productDao.getName());
        productDto.setPrice(productDao.getPrice());
        productDto.setProducer(producerConverter.mapToDto(productDao.getProducer()));
        productDto.setProducerId(productDao.getProducer().getId());
        return productDto;
    }

    public ProductDao mapToDao(final ProductDto productDto) {
        ProductDao productDao = new ProductDao();
        productDao.setId(productDto.getId());
        productDao.setName(productDto.getName());
        productDao.setPrice(productDto.getPrice());
        productDao.setProducer(producerConverter.mapToDao(productDto.getProducer()));
        return productDao;
    }
}
