package uz.azi.ecomusers.mapper;


import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.azi.ecomusers.dtos.UserCreateDto;
import uz.azi.ecomusers.dtos.UserDTo;
import uz.azi.ecomusers.dtos.UserUpdateDto;
import uz.azi.ecomusers.model.User;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTo toDto(User user);
    List<UserDTo> toDTos(List<User> users);

    User fromCreateDto(UserCreateDto dto);


    User fromUpdateDto(UserUpdateDto dto);
}
