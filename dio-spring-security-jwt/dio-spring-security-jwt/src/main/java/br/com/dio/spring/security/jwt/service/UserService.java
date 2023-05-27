package br.com.dio.spring.security.jwt.service;

import br.com.dio.spring.security.jwt.model.entity.User;
import br.com.dio.spring.security.jwt.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void createUser(User user){
        String password = user.getPassword();
        //criptografando
        user.setPassword(passwordEncoder.encode(password));
        userRepository.save(user);
    }


}
