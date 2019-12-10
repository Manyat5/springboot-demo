package com.wwy.uac.service;

import com.wwy.uac.dao.UserDao;
import com.wwy.uac.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author wwy
 */
@Service
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private UserDao userDao;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        //从数据库中查询
        UserDto user = userDao.getUserByUsername(s);
        if(user==null){
            //异常由DaoAuthenticationProvider抛
            return null;
        }
        //从数据库中查到数据，建立userDetails
        List<String> permissions = userDao.findPermissionByUserId(user.getId());
        String[] strings = new String[permissions.size()];
        return User.withUsername(user.getUsername()).
                password(user.getPassword()).
                authorities(permissions.toArray(strings)).build();
    }


}
