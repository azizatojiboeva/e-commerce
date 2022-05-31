package uz.azi.ecomusers.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.azi.ecomusers.dtos.UserCreateDto;
import uz.azi.ecomusers.dtos.UserDTo;
import uz.azi.ecomusers.dtos.UserUpdateDto;
import uz.azi.ecomusers.exceptions.UserNotFoundException;
import uz.azi.ecomusers.mapper.UserMapper;
import uz.azi.ecomusers.model.User;
import uz.azi.ecomusers.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final UserMapper mapper;

    public Long create(UserCreateDto dto) {
        User user = mapper.fromCreateDto(dto);
        Optional<User> userByUsername = repository.findUserByUsername(user.getUsername());
        if (userByUsername.isEmpty()) {
            throw new RuntimeException("User already exist");
        }
        User saved = repository.save(user);
        return saved.getId();
    }


    public Boolean update(Long id, UserUpdateDto dto) {
        repository.findById(id).orElseThrow(() ->
        {
            throw new UserNotFoundException("User not found");
        });
        repository.findUserByUsername(dto.getUsername()).orElseThrow(
                () -> {
                    throw new RuntimeException("Bad request");
                }
        );
        User user = mapper.fromUpdateDto(dto);
        repository.save(user);
        return true;
    }


    public Boolean delete(Long id) {
        repository.findById(id).orElseThrow(() ->
        {
            throw new UserNotFoundException("User not found");
        });
        repository.softDelete(id);
        return true;
    }

    public List<UserDTo> getAll() {
        return mapper.toDTos(repository.findAll());
    }



}
