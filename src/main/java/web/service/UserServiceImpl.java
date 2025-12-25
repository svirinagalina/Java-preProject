package web.dao;

import web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.service.UserService;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void add(String name, String surname) {
        User user = new User();
        user.setName(name);
        user.setSurname(surname);

        userDao.add(user);
    }

    @Override
    @Transactional(readOnly = true)
    public User getById(int id) {
        return userDao.getById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> listUsers() {
        return userDao.listUsers();
    }

    @Override
    public void update(int id, String name, String surname) {
        User user = getById(id);
        user.setName(name);
        user.setSurname(surname);

        userDao.update(user);
    }

    @Override
    public void delete(int id) {
        userDao.delete(id);
    }
}
