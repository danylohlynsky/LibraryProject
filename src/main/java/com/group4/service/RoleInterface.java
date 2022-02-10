package com.group4.service;

import com.group4.model.Role;
import org.springframework.stereotype.Component;

public interface RoleInterface {
    void save(Role role);
    void update(Role role);
}
