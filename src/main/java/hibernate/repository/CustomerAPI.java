package hibernate.repository;

import hibernate.entity.Customer;
import hibernate.util.Util;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import java.util.List;


public class CustomerAPI {

    public void create(Customer customer) {
        Transaction transaction = null;
        try (Session session = Util.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(customer);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
    public Customer findById(int id) {
        Customer result = null;
        try (Session session = Util.getSessionFactory().openSession()) {
            String query = "select * from customer where id = '" + id + "'";
            NativeQuery<Customer> nquery = session.createNativeQuery(query, Customer.class);
            List<Customer> foundCustomers = nquery.getResultList();
            if (foundCustomers.isEmpty()) {
                return result;
            } else {
                result = foundCustomers.get(0);
            }
            //session.getTransaction.commit();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }


    public Customer readByUserName(String userName) {
        Customer result = null;
        try (Session session = Util.getSessionFactory().openSession()) {
            result = session.find(Customer.class, userName);
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }


    public Customer update(String userName, Customer customer) {
        Customer result = null;
        Transaction transaction = null;
        try (Session session = Util.getSessionFactory().openSession()) {
            Customer customerToBeUpdated = session.find(Customer.class, userName);

            transaction = session.beginTransaction();

            customerToBeUpdated.setFirstName(customer.getFirstName());
            customerToBeUpdated.setLastName(customer.getLastName());
            customerToBeUpdated.setDateOfBirth(customer.getDateOfBirth());
            customerToBeUpdated.setCnp(customer.getCnp());
            customerToBeUpdated.setAddress(customer.getAddress());
            customerToBeUpdated.setEmail(customer.getEmail());
            customerToBeUpdated.setPhone(customer.getPhone());
            customerToBeUpdated.setUserName(customer.getUserName());
            customerToBeUpdated.setPassword(customer.getPassword());

            session.update(customerToBeUpdated);

            transaction.commit();
            result = session.find(Customer.class, userName);
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println(e.getMessage());
        }
        return result;
    }

    public void delete(int id) {
        Transaction transaction = null;
        try (Session session = Util.getSessionFactory().openSession()) {
            Customer accountToBeDeleted = session.find(Customer.class, id);

            transaction = session.beginTransaction();

            session.delete(accountToBeDeleted);

            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println(e.getMessage());
        }
    }
    public Customer findByUsername(String username) {
        Customer result = null;
        try (Session session = Util.getSessionFactory().openSession()) {
            String query = "select * from customer where username = '" + username + "'";

            NativeQuery<Customer> nquery = session.createNativeQuery(query, Customer.class);
            List<Customer> foundCustomers = nquery.getResultList();
            if (foundCustomers.isEmpty()) {
                return result;
            } else {
                result = foundCustomers.get(0);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }



    public long findIdByPassword (String password){
        long result = 0;
        try (Session session = Util.getSessionFactory().openSession()) {
            String query = "select customer_id from customer where password =\"" + password + "\"";
            NativeQuery<Customer> nativeQuery = session.createNativeQuery(query);
            result = nativeQuery.getFirstResult();
            session.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

}
