package br.com.dio.spring.security.jwt.controller;

import br.com.dio.spring.security.jwt.model.dto.LoginDTO;
import br.com.dio.spring.security.jwt.model.dto.SessaoDTO;
import br.com.dio.spring.security.jwt.model.entity.User;
import br.com.dio.spring.security.jwt.model.repository.UserRepository;
import br.com.dio.spring.security.jwt.security.JwtCreator;
import br.com.dio.spring.security.jwt.security.JwtObject;
import br.com.dio.spring.security.jwt.security.SecurityConfiguration;
import io.jsonwebtoken.Jwt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping
public class LoginController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private SecurityConfiguration securityConfiguration;

    @Autowired
    private UserRepository repository;

    @PostMapping("/login")
    public SessaoDTO logar(@RequestBody LoginDTO login){
        User user = repository.findByUsername(login.getUsername());
        if(user!=null) {
            boolean passwordOk =  passwordEncoder.matches(login.getPassword(), user.getPassword());
            if (!passwordOk) {
                throw new RuntimeException("Senha inválida para o login: " + login.getUsername());
            }
            //Estamos enviando um objeto Sessão para retornar mais informações do usuário
            SessaoDTO sessao = new SessaoDTO();
            sessao.setLogin(user.getUsername());

            JwtObject jwtObject = new JwtObject();
            jwtObject.setIssuedAt(new Date(System.currentTimeMillis()));
            jwtObject.setExpiration((new Date(System.currentTimeMillis() + SecurityConfiguration.EXPIRATION)));
            jwtObject.setRoles(user.getRoles());
            sessao.setToken(JwtCreator.create(SecurityConfiguration.PREFIX, SecurityConfiguration.KEY, jwtObject));
            return sessao;
        }else {
            throw new RuntimeException("Erro ao tentar fazer login");
        }
    }
}
