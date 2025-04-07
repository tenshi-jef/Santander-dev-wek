package me.dio.santander_dev_week_2023.Service;


import me.dio.santander_dev_week_2023.DTO.Read.UserResponseDTO;
import me.dio.santander_dev_week_2023.DTO.Write.UserRequestDTO;
import me.dio.santander_dev_week_2023.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService implements me.dio.santander_dev_week_2023.Service.IUserService {
    private final UserRepository repository;

    public UserService(UserRepository userRepository) {
        repository = userRepository;
    }

    /**
     * @return
     */
    @Override
    public ArrayList<UserResponseDTO> getUsers() {
        var usersDTO = new ArrayList<UserResponseDTO>();
        var users = repository.findAll();

        for (var user : users) {
            usersDTO.add(new UserResponseDTO(user.getId(),user.getNome(),user.getEmail()));
        }

        return usersDTO;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public UserResponseDTO getUser(Long id) {
        return getUsers().stream().filter(x ->x.id==id).findFirst().get();
    }

    /**
     * @param newUser
     * @return
     */
    @Override
    public Long create(UserRequestDTO newUser) {
        return 0L;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Long update(Long id) {
        return 0L;
    }
}

