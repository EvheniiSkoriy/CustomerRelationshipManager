package source.dao;

import source.entity.User;

public interface UserDAO {

    void save(User user);
    User findByUserName(String userName);
    User findByEmail(String email);
}
