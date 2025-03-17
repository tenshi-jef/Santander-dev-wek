package me.dio.santander_dev_week_2023.Service;

import me.dio.santander_dev_week_2023.Models.Usuario;
import me.dio.santander_dev_week_2023.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class UsuarioService {

    @Autowired
    private UserRepository userRepository;

    public List<Usuario> findAll() {
        return userRepository.findAll();
    }

    public Object GetById(Long id) {
    }
}
