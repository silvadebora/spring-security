package br.com.dio.spring.security.jwt.security;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
@NoArgsConstructor @AllArgsConstructor
public class JwtObject {

    private String subject; // nome do usuário
    private Date issuedAt; // data de criação do token
    private Date expiration; // data de expiração do token
    private List<String> roles; // perfis de acesso

    public void setRoles(List<String> roles){
        this.roles = roles;
    }

    public List<String> getRoles() {
        return roles;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Date getIssuedAt() {
        return issuedAt;
    }

    public void setIssuedAt(Date issuedAt) {
        this.issuedAt = issuedAt;
    }

    public Date getExpiration() {
        return expiration;
    }

    public void setExpiration(Date expiration) {
        this.expiration = expiration;
    }
}
