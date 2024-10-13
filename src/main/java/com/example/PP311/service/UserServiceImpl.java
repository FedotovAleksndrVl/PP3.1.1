package com.example.PP311.service;
import com.example.PP311.dao.UserDao;
import com.example.PP311.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDaoHibernate;

    @Override
    @Transactional
    public void saveUser(User user) {
        userDaoHibernate.saveUser(user);
    }

    @Override
    public User getUserById(Long id) {
        return userDaoHibernate.getUserById(id);
    }

    @Override
    @Transactional
    public void removeUserById(long id) {
        userDaoHibernate.removeUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDaoHibernate.getAllUsers();
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        userDaoHibernate.updateUser(user);
    }
}

