package br.com.dio.spring.security.jwt.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LoginDTO {

    private String username;
    private String password;

}
