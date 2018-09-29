package source.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import source.entity.User;



@Repository
public class UserDAOImpl implements UserDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(user);
    }

    @Override
    public User findByUserName(String userName) {
        Session session = sessionFactory.getCurrentSession();

        User user;
        Query<User> userQuery = session.createQuery("from User where username = :theName",User.class);
        userQuery.setParameter("theName",userName);

        try{
            user = userQuery.getSingleResult();
        } catch (Exception ex){
            user = null;
        }

        return user;
    }
}
