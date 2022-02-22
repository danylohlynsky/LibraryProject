package com.group4.service.implementations;

import com.group4.dao.interfaces.RoleDAO;
import com.group4.model.Book;
import com.group4.model.Role;
import com.group4.service.interfaces.RoleService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@NoArgsConstructor
@Repository
class RoleServiceImpl implements RoleService {
    private RoleDAO roleDAO;

    @Autowired
    public RoleServiceImpl(RoleDAO roleDAO) {
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

    @Override
    @Transactional
    public List<Role> listRoles() {
        return this.roleDAO.findAll(Role.class);
    }
}
