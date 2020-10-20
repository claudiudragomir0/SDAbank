package hibernate;

import hibernate.entity.*;
import hibernate.repository.AccountAPI;
import hibernate.repository.BankAPI;
import hibernate.repository.CustomerAPI;
import hibernate.repository.TransactionHistoryAPI;
import hibernate.util.Util;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.tool.schema.internal.exec.ScriptTargetOutputToFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class AppMeniu {

//		try {

//        // create a course
//        Course tempCourse = new Course("Pacman - How To Score One Million Points");
//        // add some reviews
//        tempCourse.addReview(new Review("Great course ... loved it!"));
//        tempCourse.addReview(new Review("Cool course, job well done"));
//        tempCourse.addReview(new Review("What a dumb course, you are an idiot!"));
//        // save the course ... and leverage the cascade all :-)
//        System.out.println("Saving the course");
//        System.out.println(tempCourse);
//        System.out.println(tempCourse.getReviews());
//        session.save(tempCourse);
//        // commit transaction
//        session.getTransaction().commit();
//        System.out.println("Done!");
//    }
//		finally {
//        // add clean up code
//        session.close();
//        factory.close();
//    }
//}
    public static final BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
    public static Bank bank= new Bank();
    public static Customer customer = new Customer();
    public static Account account = new Account();
    public static TransactionHistory transactionHistory= new TransactionHistory();
    public static BankAPI bankAPI= new BankAPI();
    public static CustomerAPI customerAPI = new CustomerAPI();
    public static AccountAPI accountAPI= new AccountAPI();
    public static TransactionHistoryAPI transactionHistoryAPI= new TransactionHistoryAPI();
    private hibernate.entity.bankName bankName;

    public  static void bankList(){
        Transaction transaction = null;
        try (Session session = Util.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            bank.setBankName("BUCURESTI");
            session.save(bank);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        try (Session session = Util.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            bank.setBankName("CLUJ");
            session.save(bank);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        try (Session session = Util.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            bank.setBankName("CONSTANTA");
            session.save(bank);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        try (Session session = Util.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            bank.setBankName("CRAIOVA");
            session.save(bank);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        try (Session session = Util.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            bank.setBankName("SIBIU");
            session.save(bank);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        try (Session session = Util.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            bank.setBankName("IASI");
            session.save(bank);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        try (Session session = Util.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            bank.setBankName("TIMISOARA");
            session.save(bank);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        try (Session session = Util.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            bank.setBankName("INTERNATIONAL");
            session.save(bank);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public void register() throws IOException {
        Transaction transaction = null;
        Customer result = null;
        Account result1=null;

        try (Session session = Util.getSessionFactory().openSession()) {
            session.beginTransaction();
            System.out.println("All fields are mandatory to register your bank account");
            System.out.println("Chose a branch:\n" +
                    "type: BUCURESTI for SDA BUCURESTI BANK\n" +
                    "type: CLUJ for SDA CLUJ BANK\n" +
                    "type: CONSTANTA for SDA CONSTANTA BANK\n" +
                    "type: CRAIOVA for SDA CRAIOVA BANK\n" +
                    "type: SIBIU for SDA SIBIU BANK\n" +
                    "type: IASI for SDA IASI BANK\n" +
                    "type: TIMISOARA for SDA TIMISOARA BANK\n" +
                    "type: INTERNATIONAL for SDA INTERNATIONAL BANK\n");

            int bankId;
            String bankName;
            switch (bankName = scanner.readLine().toUpperCase()) {
                case "BUCURESTI":
                    this.bankName = hibernate.entity.bankName.SDA_BUCURESTI;
                    bankId = 1;
                    break;
                case "CLUJ":
                    this.bankName = hibernate.entity.bankName.SDA_CLUJ;
                    bankId = 2;
                    break;
                case "CONSTANTA":
                    this.bankName = hibernate.entity.bankName.SDA_CONSTANTA;
                    bankId = 3;
                    break;
                case "CRAIOVA":
                    this.bankName = hibernate.entity.bankName.SDA_CRAIOVA;
                    bankId = 4;
                    break;
                case "SIBIU":
                    this.bankName = hibernate.entity.bankName.SDA_SIBIU;
                    bankId = 5;
                    break;
                case "IASI":
                    this.bankName = hibernate.entity.bankName.SDA_IASI;
                    bankId = 6;
                    break;
                case "TIMISOARA":
                    this.bankName = hibernate.entity.bankName.SDA_TIMISOARA;
                    bankId = 7;
                    break;
                case "INTERNATIONAL":
                    this.bankName = hibernate.entity.bankName.SDA_INTERNATIONAL;
                    bankId = 8;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + bankName);
            }
            Bank tempBank = session.get(Bank.class, bankId);
            Customer tempCustomer = new Customer();
            System.out.println("Enter your first name: ");
            tempCustomer.setFirstName(scanner.readLine());
            System.out.println("Enter your last name: ");
            tempCustomer.setLastName(scanner.readLine());
            System.out.println("Enter you date of birth: ");
            tempCustomer.setDateOfBirth(scanner.readLine());
            System.out.println("Enter you CNP: ");
            tempCustomer.setCnp(scanner.readLine());
            System.out.println("Enter your current adress: ");
            tempCustomer.setAddress(scanner.readLine());
            System.out.println("Enter your phone number: ");
            tempCustomer.setPhone(scanner.readLine());
            System.out.println("Enter an user name: ");
            tempCustomer.setUserName(scanner.readLine());
            System.out.println("Enter an password : ");
            tempCustomer.setPassword(scanner.readLine());
            System.out.println("Enter your email: ");
            tempCustomer.setEmail(scanner.readLine());
            session.save(tempBank);
            tempBank.addCustomers(tempCustomer);
            session.save(tempCustomer);

            int customerId=tempCustomer.getId();
            result = session.find(Customer.class, customerId);
            Account tempAccount = new Account();
            System.out.println("type :\n DEBIT EURO\n"+"DEBIT RON\n"+"CREDIT EURO\n"+"CREDIT RON\r");
            tempAccount.setAccountType(scanner.readLine().toUpperCase());
            System.out.println("Your IBAN code has been set as: \r");
            tempAccount.setIban();
            System.out.println(" ");
            session.save(tempCustomer);
            tempCustomer.addAccounts(tempAccount);
            session.save(tempAccount);


            int accountId=tempAccount.getId();
            result1=session.find(Account.class, accountId);
            TransactionHistory tempTransactionHistory = new TransactionHistory();
            tempAccount.addTransactions(tempTransactionHistory);
            session.save(tempAccount);
            int transactionId=tempTransactionHistory.getId();
            tempTransactionHistory.setAccount(tempAccount);
            tempTransactionHistory.setChanged_at(new Date());
            session.save(tempTransactionHistory);


            session.getTransaction().commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println(e.getMessage());
        }


    }

//            System.out.println("You're a few steps away to become a SDA BANK CUSTOMER");
//            session.save(customer);
//            transaction.commit();
//        } catch (HibernateException e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
//        }
//
//
//        customerAPI.create(customer);
//        accountAPI.create(account);
//        bank.addCustomers(customer);
//        customer.addAccounts(account);
//        customer.addBanks(bank);
//
//        //account.addTransactions(); //too doo
//
//        //take all details about customer and update the database
    }
//    public static void exit(){
//        //close app
//    }
//    public static void login(){
//        //validate the username and password
//    }
//    public static void afterLogin(){
//        //1view portofolio and balance
//        //2transfer money
//        //3deposit cash
//        //4create debit account /// in some currency that cusotmer wants
//        //5create credit account
//        //6general view  balance //account friendly name and iban
//        //7 transfer money
//    }
//    public static void ibanGenerator(){}

