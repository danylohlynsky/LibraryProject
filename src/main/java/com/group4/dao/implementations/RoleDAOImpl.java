package com.group4.dao.implementations;

import com.group4.dao.interfaces.RoleDAO;
import com.group4.model.Role;

import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class RoleDAOImpl extends DAOImpl<Role> implements RoleDAO {

    public RoleDAOImpl(LocalSessionFactoryBean localSessionFactoryBean) {
        super(localSessionFactoryBean);
    }

}
