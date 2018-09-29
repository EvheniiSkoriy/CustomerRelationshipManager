package source.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import source.crm.UserCRM;
import source.entity.User;

public interface UserService extends UserDetailsService {

    void save(UserCRM UserCRM);
    User findByUserName(String userName);
}
