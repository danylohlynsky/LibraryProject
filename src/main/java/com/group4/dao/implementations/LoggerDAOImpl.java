package com.group4.dao.implementations;

import com.group4.dao.interfaces.LoggerDAO;
import com.group4.model.Logger;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

public class LoggerDAOImpl extends DAOImpl<Logger> implements LoggerDAO {
    public LoggerDAOImpl(LocalSessionFactoryBean localSessionFactoryBean) {
        super(localSessionFactoryBean);
    }

}
