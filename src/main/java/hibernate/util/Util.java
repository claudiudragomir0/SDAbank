package hibernate.util;

import hibernate.entity.Account;
import hibernate.entity.Bank;
import hibernate.entity.Customer;
import hibernate.entity.TransactionHistory;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class Util {
    private static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory() {
        //java.util.logging.Logger.getLogger("org.hibernate").setLevel(OFF);
        if(sessionFactory==null){
            try{
                Configuration configuration = new Configuration();
                Properties settings = new Properties();
                settings.put(Environment. DRIVER, "com.mysql.cj.jdbc.Driver");
                settings.put(Environment.URL, "jdbc:mysql://localhost:3306/sdabank?serverTimezone=UTC");
                // settings.put(Environment.URL, "jdbc:mysql://localhost:3306/sdabank?serverTimezone=EEST");

                settings.put(Environment.USER, "root");
                settings.put(Environment.PASS, "java4Bilionaires100%");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
                settings.put(Environment.SHOW_SQL, "true");
                //  settings.put(Environment.)
                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                settings.put(Environment.HBM2DDL_AUTO, "validate");
                //settings.put(Environment.HBM2DDL_AUTO, "update");
                //settings.put(Environment.HBM2DDL_AUTO, "create-drop");


                configuration.setProperties(settings);
                configuration.addAnnotatedClass(Account.class);
                configuration.addAnnotatedClass(Bank.class);
                configuration.addAnnotatedClass(Customer.class);
                configuration.addAnnotatedClass(TransactionHistory.class);
                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();

                sessionFactory= configuration.buildSessionFactory(serviceRegistry);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}
