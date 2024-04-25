package web.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import java.util.List;

@Repository
public class UserDaoHibernateImp implements UserDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public UserDaoHibernateImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional("hibernateTransactionManager")
    public List<User> getAllUsers() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select u from User u", User.class).getResultList();

    }

    @Override
    @Transactional("hibernateTransactionManager")
    public User findUserById(long id) {
        return sessionFactory.getCurrentSession().get(User.class, id);
    }

    @Override
    @Transactional("hibernateTransactionManager")
    public void createUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    @Transactional("hibernateTransactionManager")
    public void updateUser(long id, User user) {
        User originalUser = sessionFactory.getCurrentSession().get(User.class,id);
        originalUser.setName(user.getName());
        originalUser.setAge(user.getAge());
        originalUser.setEmail(user.getEmail());
    }

    @Override
    @Transactional("hibernateTransactionManager")
    public void deleteUser(long id) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.get(User.class, id);
        session.delete(user);

    }
}
