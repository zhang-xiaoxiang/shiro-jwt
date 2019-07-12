package com.example.shirojwt.jwt;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * JwtToken:包装token的类
 *
 * @author zhangxiaoxiang
 * @date: 2019/07/12
 */
public class JwtToken implements AuthenticationToken{

    private String token;

    public JwtToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
