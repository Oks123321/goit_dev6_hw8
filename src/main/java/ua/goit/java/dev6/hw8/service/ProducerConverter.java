package ua.goit.java.dev6.hw8.service;

import org.springframework.stereotype.Service;
import ua.goit.java.dev6.hw8.model.Dao.ProducerDao;
import ua.goit.java.dev6.hw8.model.Dto.ProducerDto;

@Service
public class ProducerConverter {
    public ProducerDto mapToDto(final ProducerDao producerDao) {
        ProducerDto producerDto = new ProducerDto();
        producerDto.setId(producerDao.getId());
        producerDto.setName(producerDao.getName());
        return producerDto;
    }
    public ProducerDao mapToDao(final ProducerDto producerDto) {
        ProducerDao producerDao = new ProducerDao();
        producerDao.setId(producerDto.getId());
        producerDao.setName(producerDto.getName());
        return producerDao;
    }
}
