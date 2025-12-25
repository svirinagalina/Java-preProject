package web.service;

import web.model.User;
import java.util.List;

public interface UserService {

    void add(String name, String surname);

    User getById(int id);
    List<User> listUsers();

    void update(int id, String name, String surname);

    void delete(int id);
}
