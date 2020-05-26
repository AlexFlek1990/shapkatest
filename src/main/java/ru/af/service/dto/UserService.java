package ru.af.service.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.af.dao.entity.User;
import ru.af.dao.repo.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDto convertToDto(User user){
        UserDto userDto = new UserDto();
        userDto.setName(user.getName());
        userDto.setPassword(user.getPassword());
        return userDto;
    }

    public User convertToUser(UserDto userDto){
        User user = new User();
        user.setName(userDto.getName());
        user.setPassword(userDto.getPassword());
        return user;
    }

    public List<UserDto> getAllUsers(){
        List<UserDto> userDtoList = new ArrayList<>();
        List<User> userList =userRepository.findAll();
        for (User user : userList) {
            userDtoList.add(convertToDto(user));
        }
        return userDtoList;
    }

    public void saveUser(UserDto userDto){
        userRepository.save(convertToUser(userDto));
    }
}
