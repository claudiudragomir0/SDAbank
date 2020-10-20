package hibernate.repository;

import hibernate.entity.Account;
import hibernate.entity.Bank;
import hibernate.util.Util;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class BankAPI {
    public void create(Bank bank) {
        Transaction transaction = null;
        try (Session session = Util.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(bank);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }


    public Bank readByBankName(String bankName) {
        Bank result = null;
        try (Session session = Util.getSessionFactory().openSession()) {
            result = session.find(Bank.class, bankName);
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }


//    public Bank update(int id, Bank bankDetails) {
//        Bank result = null;
//        Transaction transaction = null;
//        try (Session session = Util.getSessionFactory().openSession()) {
//            Bank BankToBeUpdated = session.find(Bank.class, id);
//
//            transaction = session.beginTransaction();
//
//            BankToBeUpdated.setBankName(bankDetails.getBankName());
//
//            session.update(BankToBeUpdated);
//
//            transaction.commit();
//            result = session.find(Bank.class, id);
//        } catch (HibernateException e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
//            System.out.println(e.getMessage());
//        }
//        return result;
//    }

    public void delete(String bankName) {
        Transaction transaction = null;
        try (Session session = Util.getSessionFactory().openSession()) {
            Bank BankToBeDeleted = session.find(Bank.class, bankName);

            transaction = session.beginTransaction();

            session.delete(BankToBeDeleted);

            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println(e.getMessage());
        }
    }

}
