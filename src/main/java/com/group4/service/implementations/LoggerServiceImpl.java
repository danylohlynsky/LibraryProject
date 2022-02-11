package com.group4.service.implementations;

import com.group4.dao.interfaces.LoggerDAO;
import com.group4.model.Logger;
import com.group4.service.interfaces.LoggerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class LoggerServiceImpl implements LoggerService {
    private LoggerDAO loggerDAO;

    @Autowired
    public LoggerServiceImpl(LoggerDAO loggerDao) {
        this.loggerDAO = loggerDao;
    }

    @Override
    @Transactional
    public void addLog(Logger logger) {
        this.loggerDAO.save(logger);
    }

    @Override
    @Transactional
    public void updateLog(Logger logger) {
        this.loggerDAO.update(logger);
    }

    @Override
    @Transactional
    public void removeLog(int id) {
        this.loggerDAO.deleteById(id);

    }

    @Override
    @Transactional
    public Logger getLogById(int id) {
        return this.loggerDAO.findById(id);
    }

    @Override
    @Transactional
    public List<Logger> listLogs() {
        return this.loggerDAO.findAll();
    }
}
