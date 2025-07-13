package com.example.ytaxi.config.JWT;

import com.example.ytaxi.develop.login.dto.LoginDto;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class CustomUserDetails implements UserDetails {

    private final LoginDto loginDto;

    public CustomUserDetails(LoginDto loginDto) {

        this.loginDto = loginDto;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        Collection<GrantedAuthority> collection = new ArrayList<>();

        collection.add(new GrantedAuthority() {

            @Override
            public String getAuthority() {
                return loginDto.getRole();
            }
        });

        return collection;
    }

    @Override
    public String getPassword() {

        return loginDto.getPw();
    }

    @Override
    public String getUsername() {

        return loginDto.getLoginId();
    }

    @Override
    public boolean isAccountNonExpired() {

        return true;
    }

    @Override
    public boolean isAccountNonLocked() {

        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {

        return true;
    }

    @Override
    public boolean isEnabled() {

        return true;
    }
}