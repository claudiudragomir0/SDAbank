package hibernate.repository;

import hibernate.entity.Account;
import hibernate.entity.TransactionHistory;
import hibernate.util.Util;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import java.util.List;

public class AccountAPI{


    public void create(Account account) {
        Transaction transaction = null;
        try (Session session = Util.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(account);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }


    public Account readByIban(String iban) {
        Account result = null;
        try (Session session = Util.getSessionFactory().openSession()) {
            result = session.find(Account.class, iban);
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }



    public Account findByCustomerId(int customer_id) {
        Account result = null;
        try (Session session = Util.getSessionFactory().openSession()) {
            String query = "select * from account where customer_id = '" + customer_id + "'";
            NativeQuery<Account> nquery = session.createNativeQuery(query, Account.class);
            List<Account> foundCustomers = nquery.getResultList();
            if (foundCustomers.isEmpty()) {
                return result;
            } else {
                result = foundCustomers.get(0);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public void updateAccountTransaction(int id, TransactionHistory tempTransactionHistory) {
        Transaction transaction = null;
        try (Session session = Util.getSessionFactory().openSession()) {
            Account tempAccount = session.find(Account.class, id);
            transaction = session.beginTransaction();
            tempAccount.getTransactionHistoryList().add(tempTransactionHistory);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println(e.getMessage());
        }
    }

    public void updateBalance(int id,double depositamount2) {
        Transaction transaction = null;
        try (Session session = Util.getSessionFactory().openSession()) {
            Account tempAccount = session.find(Account.class, id);
            transaction = session.beginTransaction();
            tempAccount.setBalance(depositamount2);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println(e.getMessage());
        }
    }

}
