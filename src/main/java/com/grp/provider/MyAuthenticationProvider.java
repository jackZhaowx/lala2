package com.grp.provider;

/**
 * Created by Administrator on 2019/10/20 0020.
 */

import com.grp.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import java.security.NoSuchAlgorithmException;


@Component("provider")
public class MyAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserDetailsService userDetailsService;

    /**
     * 自定义验证方式
     */
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();
        UserDetails user = userDetailsService.loadUserByUsername(username);
        if (user != null) {
            String md5 = "";
            try {
                md5 = MD5Util.md5(MD5Util.DIGEST_MD5, username, password);
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            if (user.getPassword().equals(md5)) {
                return new UsernamePasswordAuthenticationToken(username, null, user.getAuthorities());
            }
        }
        return null;
    }

    @Override
    public boolean supports(Class<?> arg0) {
        return true;
    }

}
