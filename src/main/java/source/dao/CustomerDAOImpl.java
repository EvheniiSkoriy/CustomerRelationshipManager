package source.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import source.entity.Customer;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    //need to inject a session factory
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {

        //get the current hibernate session
        Session session=sessionFactory.getCurrentSession();
        //create a query
        Query<Customer> customerQuery=
                session.createQuery("select c from Customer c order by lastName",
                        Customer.class);
        //get the list of Customers
        List<Customer> customerList=customerQuery.getResultList();
        return customerList;
    }

    @Override
    public void saveCustomer(Customer theCustomer) {
        Session session=sessionFactory.getCurrentSession();
        session.saveOrUpdate(theCustomer);
    }

    @Override
    public Customer getCustomerById(Integer id) {
        Session session=sessionFactory.getCurrentSession();
        return session.get(Customer.class,id);
    }

    @Override
    public void deleteCustomerById(Integer id) {
        Session session=sessionFactory.getCurrentSession();

        //first way
        //session.delete(session.get(Customer.class,id));

        //second way
        Query<Customer> query=
                session.createQuery("delete from Customer where id=:customerId");
        query.setParameter("customerId",id);
        query.executeUpdate();
    }

    @Override
    @Transactional
    public List<Customer> getCustomersByLastName(String lastName) {
        Session session=sessionFactory.getCurrentSession();
        Query<Customer> query;

        if(lastName!=null && lastName.trim().length()>0){
            query= session
                    .createQuery("from Customer where lower(lastName) like :theName ",Customer.class);
            query.setParameter("theName", "%" + lastName.toLowerCase() + "%");
        }else{
            query= session.createQuery("select c from Customer c",Customer.class);
        }


        List<Customer> customers = query.getResultList();

        return customers;
    }


}
