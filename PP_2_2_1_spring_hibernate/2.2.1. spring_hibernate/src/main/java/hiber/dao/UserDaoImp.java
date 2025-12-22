package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {
        org.hibernate.Session session =
                sessionFactory.getCurrentSession();
        if (user.getCar() != null) {
            session.save(user.getCar());
        }
        session.save(user);
    }

    @Override
    public User findUserByCar(String model, int series) {
        org.hibernate.Session session = sessionFactory.getCurrentSession();
        return session.createQuery(
                        "from User u where u.car.model = :model and u.car.series = :series",
                        User.class)
                .setParameter("model", model)
                .setParameter("series", series)
                .getSingleResult();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

}
