package source.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import source.entity.Role;

@Repository
public class RoleDAOImpl implements RoleDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Role findRoleByName(String name) {
        Session session = sessionFactory.getCurrentSession();

        Role role;
        Query<Role> roleQuery = session.createQuery("from Role where name = :rolename",Role.class);
        roleQuery.setParameter("rolename",name);

        try{
            role = roleQuery.getSingleResult();
        } catch (Exception ex){
            role = null;
        }

        return role;
    }
}
