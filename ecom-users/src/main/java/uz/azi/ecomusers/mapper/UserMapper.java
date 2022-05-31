package uz.azi.ecomusers.mapper;


import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.azi.ecomusers.dtos.UserCreateDto;
import uz.azi.ecomusers.dtos.UserDto;
import uz.azi.ecomusers.dtos.UserUpdateDto;
import uz.azi.ecomusers.model.User;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toDto(User user);
    List<UserDto> toDTos(List<User> users);

    User fromCreateDto(UserCreateDto dto);


    User fromUpdateDto(UserUpdateDto dto);
}
