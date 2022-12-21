package ua.goit.java.dev6.hw8.service;

import org.springframework.stereotype.Service;
import ua.goit.java.dev6.hw8.model.Dao.UserDao;
import ua.goit.java.dev6.hw8.model.Dto.UserDto;


@Service
public class UserConverter {

    public UserDto mapToDto(UserDao userDao) {
        UserDto userDto = new UserDto();
        userDto.setId(userDao.getId());
        userDto.setEmail(userDao.getEmail());
        userDto.setPassword(userDao.getPassword());
        userDto.setFirstName(userDao.getFirstName());
        userDto.setLastName(userDao.getLastName());
        userDto.setRoles(userDao.getRoles());
        return userDto;
    }

    public UserDao mapToDao(UserDto userDto){
        UserDao userDao = new UserDao();
        userDao.setId(userDto.getId());
        userDao.setEmail(userDto.getEmail());
        userDao.setPassword(userDto.getPassword());
        userDao.setFirstName(userDto.getFirstName());
        userDao.setLastName(userDto.getLastName());
        userDao.setRoles(userDto.getRoles());
        return userDao;
    }

}
