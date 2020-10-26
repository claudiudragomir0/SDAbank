package hibernate.repository;

import hibernate.entity.TransactionHistory;
import hibernate.util.Util;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TransactionHistoryAPI {
    public void create(TransactionHistory transactionHistory) {
        Transaction transaction = null;
        try (Session session = Util.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(transactionHistory);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }


    public TransactionHistory readById(int id) {
        TransactionHistory result = null;
        try (Session session = Util.getSessionFactory().openSession()) {
            result = session.find(TransactionHistory.class, id);
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }


//    public TransactionHistory update(int id, TransactionHistory transactionHistoryDetails) {
//        TransactionHistory result = null;
//        Transaction transaction = null;
//        try (Session session = Util.getSessionFactory().openSession()) {
//            TransactionHistory transactionToBeUpdated = session.find(TransactionHistory.class, id);
//
//            transaction = session.beginTransaction();
//
//            transactionToBeUpdated.setDeposit(transactionHistoryDetails.getDeposit());
//            transactionToBeUpdated.setAmount(transactionHistoryDetails.getAmount());
//            transactionToBeUpdated.setBalance(transactionToBeUpdated.getBalance());
//            transactionToBeUpdated.setWithdraw(transactionToBeUpdated.getWithdraw());
//            transactionToBeUpdated.setCurrency(transactionToBeUpdated.getCurrency());
//
//            session.update(transactionToBeUpdated);
//
//            transaction.commit();
//            result = session.find(TransactionHistory.class, id);
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
            TransactionHistory transactionToBeDeleted = session.find(TransactionHistory.class, id);

            transaction = session.beginTransaction();

            session.delete(transactionToBeDeleted);

            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println(e.getMessage());
        }
    }

}
