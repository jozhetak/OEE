package com.conciencia.config.security;


import com.conciencia.pojo.SysUser;
import com.conciencia.service.SysUserService;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
    
    @Resource
    SysUserService sysUserService;
    
    @Override
    public Authentication authenticate(Authentication authentication)
                                                throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        
        SysUser user = sysUserService.findByUserName(username);
        
        if(user != null && password.equals(user.getPassword())){
            List<GrantedAuthority> grantedAuths = new ArrayList<>();
            grantedAuths.add(new SimpleGrantedAuthority(user.getRolName()));
            Authentication auth 
                = new UsernamePasswordAuthenticationToken(
                                        username, password, grantedAuths);
            return auth;
        }
        return null;
    }
 
    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}