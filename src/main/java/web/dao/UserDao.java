package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();
    User findUserById(long id);
    void createUser(User user);
    void updateUser(long id, User user);
    void deleteUser(long id);
}
