package br.com.dio.spring.security.jwt.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SessaoDTO {

    private String login;
    private String token;

}
