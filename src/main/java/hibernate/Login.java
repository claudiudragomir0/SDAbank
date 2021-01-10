package hibernate;

import hibernate.entity.Bank;
import hibernate.entity.Customer;
import hibernate.repository.CustomerAPI;
import hibernate.util.Util;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {
    JLabel userName, password, underTitleMsg, apptitle, image;
    JButton login, back;
    JPanel header;
    JTextField boxUserName;
    JPasswordField boxUserPassword;
    int color;
    public static Bank bank = new Bank();
    public static Transaction transaction = null;
    private static boolean oConditie = true;
    public static CustomerAPI customerAPI = new CustomerAPI();

    Login(String title, int v) {

        color = v;
        Cursor handpointer = new Cursor(Cursor.HAND_CURSOR);
        Font formfont = new Font("SansSerif", Font.PLAIN, 15);
        Font btnFont = new Font("SansSerif", Font.PLAIN, 15);
        Font bankline = new Font("SansSerif", Font.BOLD, 25);
        Font signinfont = new Font("SansSerif", Font.BOLD, 20);
        Color bgcolor = new Color(52, 152, 219);
        Color btncolor = new Color(52, 73, 94);
        header = new JPanel(null);
        apptitle = new JLabel("SDA BANK APP");
        ImageIcon img = new ImageIcon("logo.png");
        image = new JLabel(img);
        underTitleMsg = new JLabel("SignIn*add more");
        userName = new JLabel("Enter the User Name:");
        boxUserName = new JTextField();
        boxUserPassword = new JPasswordField();
        password = new JLabel("Enter your password:");
        login = new JButton("LOGIN");
        back = new JButton("BACK");
        apptitle.setForeground(Color.WHITE);
        apptitle.setFont(bankline);
        underTitleMsg.setFont(signinfont);
        underTitleMsg.setForeground(Color.BLACK);
        login.setFont(btnFont);
        login.setBackground(btncolor);
        login.setForeground(Color.WHITE);
        login.setCursor(handpointer);
        back.setFont(btnFont);
        back.setBackground(btncolor);
        back.setCursor(handpointer);
        back.setForeground(Color.WHITE);
        userName.setForeground(Color.BLACK);
        userName.setFont(formfont);
        password.setForeground(Color.BLACK);
        password.setFont(formfont);
        header.setBackground(btncolor);
        this.setLayout(null);
        header.setBounds(0, 0, 500, 50);
        image.setBounds(45, 0, 100, 50);
        apptitle.setBounds(121, 10, 400, 50);
        underTitleMsg.setBounds(200, 60, 400, 50);
        userName.setBounds(33, 110, 150, 40);
        boxUserName.setBounds(180, 110, 220, 35);
        password.setBounds(33, 160, 150, 40);
        boxUserPassword.setBounds(180, 165, 220, 35);
        login.setBounds(260, 220, 150, 40);
        back.setBounds(50, 220, 150, 40);
        this.add(header);
        header.add(image);
        header.add(apptitle);
        this.add(underTitleMsg);
        this.add(userName);
        this.add(boxUserName);
        this.add(password);
        this.add(boxUserPassword);
        this.add(login);
        this.add(back);
        ChangeColor(color);
        back.addActionListener(new MyEvents());
        login.addActionListener(new MyEvents());
        ImageIcon icon = new ImageIcon("i2.jpg");
        this.setIconImage(icon.getImage());
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle(title);
        this.setBounds(520, 225, 450, 300);
        this.setVisible(true);
    }

    public void ChangeColor(int v) {
        int rgb[] = {52, 73, 94};
        switch (v) {
            case 1:
                rgb[0] = 26;
                rgb[1] = 188;
                rgb[2] = 156;
                break;
            case 2:
                rgb[0] = 22;
                rgb[1] = 160;
                rgb[2] = 133;
                break;
            case 3:
                rgb[0] = 46;
                rgb[1] = 204;
                rgb[2] = 133;
                break;
            case 4:
                rgb[0] = 39;
                rgb[1] = 174;
                rgb[2] = 96;
                break;
            case 5:
                rgb[0] = 241;
                rgb[1] = 196;
                rgb[2] = 15;
                break;
            case 6:
                rgb[0] = 243;
                rgb[1] = 156;
                rgb[2] = 181;
                break;
            case 7:
                rgb[0] = 211;
                rgb[1] = 84;
                rgb[2] = 0;
                break;
            case 8:
                rgb[0] = 155;
                rgb[1] = 89;
                rgb[2] = 182;
                break;
            case 9:
                rgb[0] = 142;
                rgb[1] = 68;
                rgb[2] = 173;
                break;
            case 10:
                rgb[0] = 52;
                rgb[1] = 73;
                rgb[2] = 94;
                break;
            case 11:
                rgb[0] = 44;
                rgb[1] = 62;
                rgb[2] = 80;
                break;
            case 12:
                rgb[0] = 189;
                rgb[1] = 195;
                rgb[2] = 199;
                break;
            case 13:

                rgb[0] = 149;
                rgb[1] = 165;
                rgb[2] = 166;
                break;
            case 14:

                rgb[0] = 127;
                rgb[1] = 140;
                rgb[2] = 141;
                color = 0;
                break;
        }
        Color btncolor = new Color(rgb[0], rgb[1], rgb[2]);
        login.setBackground(btncolor);
        back.setBackground(btncolor);
        header.setBackground(btncolor);
    }

    public void hideFrame() {
        this.dispose();
    }

    public static void main(String args[]) {
        Login obj = new Login("LOGIN", 0);
    }

    class MyEvents implements ActionListener {
        public void actionPerformed(ActionEvent btnop) {
            if (btnop.getSource() == back) {
                StartUp obj = new StartUp("SDA BANK", color);
                Login.this.hideFrame();
            }
            if (btnop.getSource() == login) {
                try {
                    String textUserName = boxUserName.getText();
                    String textPassword = boxUserPassword.getText();
                    int flag = 0;
                    if (textUserName.equals("") || textUserName.equals("             Empty Field!")) {
                        boxUserName.setFont(new Font("SansSerif", Font.PLAIN, 17));
                        boxUserName.setForeground(Color.RED);
                        boxUserName.setText("             Empty Field!");
                        flag = 1;
                    }
                    if (textPassword.equals("")) {
                        boxUserPassword.setBackground(Color.RED);
                        flag = 1;
                    }
                    if (textUserName.equals("admin")||textPassword.equals("admin")){
                        bankList();
                    }
                    if (flag == 0) {
                        Customer tempCustomer;
                        if (oConditie) {
                            tempCustomer = customerAPI.findByUsername(textUserName);
                            if (tempCustomer == null) {
                                JOptionPane.showMessageDialog(null,
                                        "ID or Password Incorrect!",
                                        "Login Failed", JOptionPane.ERROR_MESSAGE);
                                oConditie = false;
                            }else if (tempCustomer != null) {
                                String tempUsername = tempCustomer.getUserName();
                                if (textUserName.matches(tempUsername)) {
                                    if (!textPassword.equals(tempCustomer.getPassword())) {
                                        oConditie = false;
                                    } else {
                                        UserInteraction obj=new UserInteraction("Account Manager",tempCustomer.getId(),color);
                                        Login.this.hideFrame();
                                        oConditie = true;

                                    }
                                }
                            }
                        }
                    }else{JOptionPane.showMessageDialog(null, "ID or Password Incorrect!","Login Failed", JOptionPane.ERROR_MESSAGE);}
                }
             catch(Exception e){JOptionPane.showMessageDialog(null,e,"Login Failed",JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    public static void bankList() {
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
    }
}

