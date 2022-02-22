package com.group4.dao.interfaces;

import com.group4.model.User;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

public interface UserDAO extends DAO<User> {
    User findByMail(String email) throws MessagingException, IOException;
}
