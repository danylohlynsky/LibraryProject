package com.group4.service.interfaces;

import com.group4.model.Book;
import com.group4.model.Role;

import java.util.List;

public interface RoleService {
    void save(Role role);
    void update(Role role);
    List<Role> listRoles();
}
