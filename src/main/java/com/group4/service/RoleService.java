package com.group4.service;

import com.group4.dao.RoleDAO;
import com.group4.model.Role;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@NoArgsConstructor
@Repository
class RoleService implements RoleInterface {
    private RoleDAO roleDAO;

    @Autowired
    public RoleService(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }

    @Override
    public void save(Role role) {
        roleDAO.create(role);
    }

    @Override
    public void update(Role role) {
        roleDAO.update(role);
    }
}
