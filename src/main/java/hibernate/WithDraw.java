package hibernate;

import hibernate.entity.Account;
import hibernate.entity.TransactionHistory;
import hibernate.util.Util;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class WithDraw  extends JFrame {

    JLabel sign, Bankname, image;
    JButton exit, back, withDrawBtn;
    JPanel header;
    JTextField withDrawBox;
    int accno1, color;
    public static Transaction transaction = null;
    public static Account result1 = null;

    WithDraw(String title, int id, int v) {
        color = v;
        accno1 = id;
        Cursor handpointer = new Cursor(Cursor.HAND_CURSOR);
        Font formfont = new Font("SansSerif", Font.PLAIN, 20);
        Font btnFont = new Font("SansSerif", Font.PLAIN, 15);
        Font bankline = new Font("SansSerif", Font.BOLD, 25);
        Font username = new Font("SansSerif", Font.BOLD, 20);
        Color bgcolor = new Color(52, 152, 219);
        header = new JPanel(null);
        Bankname = new JLabel("SDA BANK ACCOUNT");
        ImageIcon img = new ImageIcon("logo.png");
        image = new JLabel(img);
        withDrawBox = new JTextField();
        withDrawBtn = new JButton("WithDraw");
        withDrawBtn.setFont(btnFont);
        withDrawBtn.setForeground(Color.WHITE);
        exit = new JButton("EXIT");
        back = new JButton("BACK");
        Bankname.setForeground(Color.WHITE);
        Bankname.setFont(bankline);
        exit.setFont(btnFont);
        exit.setBackground(Color.RED);
        exit.setForeground(Color.WHITE);
        exit.setCursor(handpointer);
        back.setFont(btnFont);
        back.setCursor(handpointer);
        back.setForeground(Color.WHITE);
        this.setLayout(null);
        header.setBounds(0, 0, 500, 50);
        image.setBounds(45, 0, 100, 50);
        Bankname.setBounds(121, 10, 400, 50);
        sign = new JLabel("Enter the amount:");
        sign.setFont(formfont);
        sign.setForeground(Color.BLACK);
        sign.setBounds(25, 60, 300, 40);
        withDrawBox.setBounds(210, 60, 210, 40);
        withDrawBtn.setBounds(120, 120, 200, 50);
        exit.setBounds(260, 201, 150, 40);
        back.setBounds(50, 201, 150, 40);
        ChangeColor(color);
        this.add(header);
        header.add(image);
        header.add(Bankname);
        this.add(sign);
        this.add(withDrawBox);
        this.add(exit);
        this.add(back);
        this.add(withDrawBtn);
        withDrawBtn.addActionListener(new MyEvents());
        back.addActionListener(new MyEvents());
        exit.addActionListener(new MyEvents());
        ImageIcon icon = new ImageIcon("i2.jpg");
        this.setIconImage(icon.getImage());
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle(title);
        this.setBounds(520, 225, 450, 280);
        this.setVisible(true);
    }

    public void hideFrame() {
        this.dispose();
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
        back.setBackground(btncolor);
        withDrawBtn.setBackground(btncolor);
        header.setBackground(btncolor);
    }

    public static void main(String args[]) {
        WithDraw obj = new WithDraw("WithDraw", 0, 0);
    }

    class MyEvents implements ActionListener {
        public void actionPerformed(ActionEvent btnop) {
            if (btnop.getSource() == exit) {
                WithDraw.this.hideFrame();
            }
            if (btnop.getSource() == withDrawBtn) {
                double currentbal;
                int flag = 0;
                String withDrawAmount = withDrawBox.getText();
                if (withDrawAmount.equals("") || withDrawAmount.equals("             Empty Field!")) {
                    withDrawBox.setFont(new Font("SansSerif", Font.PLAIN, 17));
                    withDrawBox.setForeground(Color.RED);
                    withDrawBox.setText("            Empty Field!");
                    flag = 1;
                }

                if (flag == 0) {
                    double withDrawAmount2 = Double.parseDouble(withDrawAmount);

                    try (Session session = Util.getSessionFactory().openSession()) {
                        transaction = session.beginTransaction();

                        Account tempAccount = session.get(Account.class, accno1);
                        currentbal = tempAccount.getBalance();
                        double balance = currentbal - withDrawAmount2;
                        tempAccount.setBalance(balance);


                        session.getTransaction().commit();
                        UserInteraction obj = new UserInteraction("Account Manager", accno1, color);
                    } catch (Exception e) {
                        if (transaction != null) {
                            transaction.rollback();
                        }
                        JOptionPane.showMessageDialog(null, e, "Error message", JOptionPane.ERROR_MESSAGE);

                    }

                    try (Session session = Util.getSessionFactory().openSession()) {
                        transaction = session.beginTransaction();
                        result1 = session.find(Account.class, accno1);
                        TransactionHistory tempTransactionHistory = new TransactionHistory();
                        result1.getTransactionHistoryList().add(tempTransactionHistory);
                        session.update(result1);
                        tempTransactionHistory.setAccount(result1);
                        Account tempAccount = session.get(Account.class, accno1);
                        tempTransactionHistory.setBalance(tempAccount.getBalance());
                        tempTransactionHistory.setWithdraw(withDrawAmount2);
                        tempTransactionHistory.setCurrency(""+result1.getCurrency());
                        tempTransactionHistory.setChanged_at(new Date());
                        session.save(tempTransactionHistory);
                        session.getTransaction().commit();
                        WithDraw.this.hideFrame();

                    } catch (Exception e) {
                        if (transaction != null) {
                            transaction.rollback();
                        }
                        JOptionPane.showMessageDialog(null, e, "Error message", JOptionPane.ERROR_MESSAGE);

                    }
                }
            }
            if (btnop.getSource() == back) {
                UserInteraction obj = new UserInteraction("Account Manager", accno1, color);
                WithDraw.this.hideFrame();
            }
        }
    }
}
