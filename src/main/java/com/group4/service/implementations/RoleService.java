package com.group4.service.implementations;

import com.group4.dao.interfaces.RoleDAO;
import com.group4.model.Role;
import com.group4.service.interfaces.RoleInterface;
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
        roleDAO.save(role);
    }

    @Override
    public void update(Role role) {
        roleDAO.update(role);
    }
}
