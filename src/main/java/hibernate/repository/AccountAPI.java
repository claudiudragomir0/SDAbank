package hibernate.repository;

import hibernate.entity.Account;
import hibernate.util.Util;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

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

//nu trebuie update la account
//    public Account update(int id, Account accountDetails) {
//        Account result = null;
//        Transaction transaction = null;
//        try (Session session = Util.getSessionFactory().openSession()) {
//            Account accountToBeUpdated = session.find(Account.class, id);
//
//            transaction = session.beginTransaction();
//
//
//            accountToBeUpdated.setIban();
//            accountToBeUpdated.setAccountType();
//
//            session.update(accountToBeUpdated);
//
//            transaction.commit();
//            result = session.find(Account.class, id);
//        } catch (HibernateException e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
//            System.out.println(e.getMessage());
//        }
//        return result;
//    }

    public void delete(int id) {
        Transaction transaction = null;
        try (Session session = Util.getSessionFactory().openSession()) {
            Account accountToBeDeleted = session.find(Account.class, id);

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
}
