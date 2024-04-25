package web.service;

import web.model.User;
import web.repository.UserRepository;

import java.util.List;


public interface UserService {
    List<User> getAllUsers();
    User findUserById(long id);
    void createUser(User user);
    void updateUser(long id, User user);
    void deleteUser(long id);
}
