package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void add(User user) {
        entityManager.persist(user);
    }

    public User getById(int id) {
        return entityManager.find(User.class, id);
    }

    public List<User> listUsers() {
        TypedQuery<User> query =
                entityManager.createQuery("SELECT u FROM User u", User.class);
        return query.getResultList();
    }

    public void update(User user) {
        entityManager.merge(user);
    }

    public void delete(int id) {
        User user = entityManager.find(User.class, id);
        if (user != null) {
            entityManager.remove(user);
        }
    }
}
