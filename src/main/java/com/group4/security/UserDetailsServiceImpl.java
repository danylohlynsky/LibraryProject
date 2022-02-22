package com.group4.security;

import com.group4.dao.interfaces.RoleDAO;
import com.group4.dao.interfaces.UserDAO;
import com.group4.model.Role;
import com.group4.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private RoleDAO roleDao;

    @Autowired
    private UserDAO userDao;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String userMail) throws UsernameNotFoundException {
        User user = null;
        try {
            user = userDao.findByMail(userMail);
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (user == null) {
            throw new UsernameNotFoundException("User not found!");
        }
        Set<GrantedAuthority> grantedAuthority = new HashSet<>();

        for (Role role : roleDao.findAll(Role.class)) {
            grantedAuthority.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), grantedAuthority);
     }
}

