package source.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import source.crm.UserCRM;
import source.dao.RoleDAO;
import source.dao.UserDAO;
import source.entity.Role;
import source.entity.User;
import source.exception.UserNotFoundException;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private RoleDAO roleDAO;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void save(UserCRM userCRM) {
        User user = new User();
        user.setUserName(userCRM.getUserName());
        user.setPassword(passwordEncoder.encode(userCRM.getPassword()));
        user.setLastName(userCRM.getLastName());
        user.setEmail(userCRM.getEmail());
        user.setRoles(Arrays.asList(roleDAO.findRoleByName("ROLE_EMPLOYEE")));
        userDAO.save(user);
    }

    @Override
    @Transactional
    public User findByUserName(String userName) {
        return findByUserName(userName);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String s) throws UserNotFoundException {
        User user = userDAO.findByUserName(s);

        if(user == null){
            throw new UserNotFoundException("Invalid username or password");
        }
        return new org.springframework.security.core.userdetails.User(user.getUserName(),user.getPassword(),
                mapRolesToAuthorities(user.getRoles()));
    }
    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
