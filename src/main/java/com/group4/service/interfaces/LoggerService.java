package com.group4.service.interfaces;

import com.group4.model.Book;
import com.group4.model.Logger;

import java.util.List;

public interface LoggerService {
    void addLog(Logger logger);

    void updateLog(Logger logger);

    void removeLog(int id);

    Logger getLogById(int id);

    List<Logger> listLogs();
}
