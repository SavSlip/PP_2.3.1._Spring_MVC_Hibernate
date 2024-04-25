package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;
import web.repository.UserRepository;

import java.util.List;
//hibernateTransactionManager
@Service
@Transactional(readOnly = true, value = "transactionManager")
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userDAO;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true, value = "hibernateTransactionManager")
    public User findUserById(long id) {
        return userDAO.findUserById(id);
    }

    @Override
    @Transactional(value = "hibernateTransactionManager")
    public void createUser(User user) {
        userDAO.createUser(user);
    }

    @Override
    @Transactional("transactionManager")
    public void updateUser(long id, User user) {
        user.setId(id);
        userRepository.save(user);
    }

    @Override
    @Transactional("transactionManager")
    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }
}
