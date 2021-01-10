package hibernate;

import hibernate.entity.Account;
import hibernate.entity.Customer;
import hibernate.repository.AccountAPI;
import hibernate.repository.CustomerAPI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class UserInteraction extends JFrame {
    public static CustomerAPI customerAPI = new CustomerAPI();
    public static AccountAPI accountAPI = new AccountAPI();



    JPanel header;
        JLabel logo, bankname, selectline, display_name,accDetails0,accDetails1,accDetails2,accDetails3,accDetails4,accDetails5,accDetails6;
        JButton depositBtn, withDrawBtn, transferBtn, accDetailsBtn, close, modifyDetailsBtn, transactionHisBtn, exit;
        int accno1;
        int color;

        UserInteraction(String title, int id, int v) {
            color = v;
            accno1 = id;
            ImageIcon icon = new ImageIcon("i2.jpg");
            ImageIcon img = new ImageIcon("logo.png");
            logo = new JLabel(img);
            Font banknamefont = new Font("SansSerif", Font.BOLD, 25);
            Font selectlinefont = new Font("SansSerif", Font.BOLD, 20);
            Font username = new Font("SansSerif", Font.BOLD, 25);
            Font btnfont = new Font("SansSerif", Font.PLAIN, 15);
            Font accDetails = new Font("SansSerif", Font.BOLD, 15);
            Color btncolor = new Color(52, 73, 94);
            Color bgcolor = new Color(52, 152, 219);
            Cursor handpointer = new Cursor(Cursor.HAND_CURSOR);
            try {
                Customer tempCustomer;
                Account tempAccount;
                tempCustomer = customerAPI.findById(accno1);
                tempAccount = accountAPI.findByCustomerId(accno1);
                    display_name = new JLabel("Welcome  " + tempCustomer.getFirstName() + "  " + tempCustomer.getLastName());
                    display_name.setFont(username);
                    display_name.setForeground(Color.BLACK);
                    display_name.setBounds(10, 51, 500, 40);
                    accDetails0 = new JLabel("Balance: "+tempAccount.getBalance()+ " " +tempAccount.getCurrency());
                    accDetails0.setFont(accDetails);
                    accDetails0.setForeground(Color.BLUE);
                    accDetails0.setBounds(10,160,300,40);
                    accDetails1 = new JLabel("User: "+tempCustomer.getUserName());
                    accDetails1.setFont(accDetails);
                    accDetails1.setForeground(Color.BLACK);
                    accDetails1.setBounds(10,200,300,40);
                    accDetails2 = new JLabel("Date Of Birth: "+tempCustomer.getDateOfBirth());
                    accDetails2.setFont(accDetails);
                    accDetails2.setForeground(Color.BLACK);
                    accDetails2.setBounds(10,235,300,25);
                    accDetails3 = new JLabel("CNP: "+tempCustomer.getCnp());
                    accDetails3.setFont(accDetails);
                    accDetails3.setForeground(Color.BLACK);
                    accDetails3.setBounds(10,270,300,25);
                    accDetails4 = new JLabel("Adress: "+tempCustomer.getAddress());
                    accDetails4.setFont(accDetails);
                    accDetails4.setForeground(Color.BLACK);
                    accDetails4.setBounds(10,305,300,25);
                    accDetails5 = new JLabel("Email: "+tempCustomer.getEmail());
                    accDetails5.setFont(accDetails);
                    accDetails5.setForeground(Color.BLACK);
                    accDetails5.setBounds(10,340,300,25);
                    accDetails6 = new JLabel("Iban:"+tempAccount.getIban());
                    accDetails6.setFont(accDetails);
                    accDetails6.setForeground(Color.BLACK);
                    accDetails6.setBounds(10,375,300,25);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e, "Error message", JOptionPane.ERROR_MESSAGE);
            }
            this.setLayout(null);
            header = new JPanel(null);
            bankname = new JLabel("SDA BANK APP");
            bankname.setFont(btnfont);
            bankname.setForeground(Color.WHITE);
            selectline = new JLabel("SELECT YOUR OPTION");
            selectline.setFont(username);
            selectline.setForeground(Color.BLACK);

            depositBtn = new JButton("Deposit");
            depositBtn.setFont(btnfont);
            depositBtn.setForeground(Color.WHITE);
            depositBtn.setCursor(handpointer);
            depositBtn.addActionListener(new MyEvents());
            withDrawBtn = new JButton("With Draw");
            withDrawBtn.setFont(btnfont);
            withDrawBtn.setForeground(Color.WHITE);
            withDrawBtn.setCursor(handpointer);
            withDrawBtn.addActionListener(new MyEvents());
            transferBtn = new JButton("Transfer Cash");
            transferBtn.setFont(btnfont);
            transferBtn.setForeground(Color.WHITE);
            transferBtn.setCursor(handpointer);
            transferBtn.addActionListener(new MyEvents());

            accDetailsBtn = new JButton("Account Details");
            accDetailsBtn.setFont(btnfont);
            accDetailsBtn.setForeground(Color.WHITE);
            accDetailsBtn.setCursor(handpointer);
            accDetailsBtn.addActionListener(new MyEvents());
            close = new JButton("Log Out");
            close.setFont(btnfont);
            close.setForeground(Color.WHITE);
            close.setCursor(handpointer);
            close.addActionListener(new MyEvents());
            modifyDetailsBtn = new JButton("Modify Details");
            modifyDetailsBtn.setFont(btnfont);
            modifyDetailsBtn.setForeground(Color.WHITE);
            modifyDetailsBtn.setCursor(handpointer);
            modifyDetailsBtn.addActionListener(new MyEvents());
            exit = new JButton("Exit");
            exit.setFont(btnfont);
            exit.setForeground(Color.WHITE);
            exit.setBackground(Color.RED);
            exit.setCursor(handpointer);
            exit.addActionListener(new MyEvents());
            transactionHisBtn = new JButton("Transaction History");
            transactionHisBtn.setFont(btnfont);
            transactionHisBtn.setForeground(Color.WHITE);
            transactionHisBtn.setCursor(handpointer);
            transactionHisBtn.addActionListener(new MyEvents());
            header.setBounds(0, 0, 600, 50);
            selectline.setBounds(10, 100, 300, 40);
            depositBtn.setBounds(350, 102, 230, 40);
            withDrawBtn.setBounds(350, 152, 230, 40);
            transferBtn.setBounds(350, 202, 230, 40);
            accDetailsBtn.setBounds(350, 252, 230, 40);
            modifyDetailsBtn.setBounds(350, 302, 230, 40);
            transactionHisBtn.setBounds(350, 352, 230, 40);
            close.setBounds(350, 460, 230, 40);
            exit.setBounds(10, 460, 230, 40);
            bankname.setBounds(200, 0, 250, 50);
            bankname.setFont(banknamefont);
            logo.setBounds(150, 0, 50, 50);
            ChangeColor(color);
            this.add(header);
            header.add(logo);
            header.add(bankname);
            this.add(selectline);
            this.add(depositBtn);
            this.add(withDrawBtn);
            this.add(transferBtn);
            this.add(accDetailsBtn);
            this.add(close);
            this.add(modifyDetailsBtn);
            this.add(transactionHisBtn);
            this.add(display_name);
            this.add(accDetails0);
            this.add(accDetails1);
            this.add(accDetails2);
            this.add(accDetails3);
            this.add(accDetails4);
            this.add(accDetails5);
            this.add(accDetails6);
            this.add(exit);
            this.setTitle(title);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setResizable(false);
            this.setIconImage(icon.getImage());
            this.setBounds(500, 100, 600, 540);
            this.setVisible(true);
        }

        public void closeFrame() {
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

            depositBtn.setBackground(btncolor);
            withDrawBtn.setBackground(btncolor);
            transferBtn.setBackground(btncolor);
            accDetailsBtn.setBackground(btncolor);
            close.setBackground(btncolor);
            modifyDetailsBtn.setBackground(btncolor);
            transactionHisBtn.setBackground(btncolor);
            header.setBackground(btncolor);
        }

        public static void main(String args[]) {
            UserInteraction obj = new UserInteraction("Account Manager", 0, 0);
        }

        public class MyEvents implements ActionListener {
            public void actionPerformed(ActionEvent op) {

                if (op.getSource() == depositBtn) {
                    Deposit obj = new Deposit("DEPOSIT",accno1, color);
                    UserInteraction.this.closeFrame();
                }
                if (op.getSource() == withDrawBtn) {
                    WithDraw obj = new WithDraw("WithDraw", accno1, color);
                    UserInteraction.this.closeFrame();
                }
//                if (op.getSource() == tcash) {
//                    TransferAmount obj = new TransferAmount("TransferAmount", accno1, color);
//                    UserTransactions.this.closeFrame();
//                }
//                if (op.getSource() == search) {
//                    Search obj = new Search("Search", accno1, color);
//                    UserTransactions.this.closeFrame();
//                }
//                if (op.getSource() == currencyexc) {
//                    CurrencyExchange obj = new CurrencyExchange("CurrencyExchange", accno1, color);
//                    UserTransactions.this.closeFrame();
//                }
//                if (op.getSource() == accdetails) {
//                    AccountDetails obj = new AccountDetails("AccountDetails", accno1, color);
//                    UserTransactions.this.closeFrame();
//                }
                if (op.getSource() == close) {
                    UserInteraction.this.closeFrame();
                    StartUp obj=new StartUp("SDA APP",color);
                }
//                if (op.getSource() == modifydet) {
//                    ModifyDetails obj = new ModifyDetails("ModifyDetails", accno1, color);
//                    UserTransactions.this.closeFrame();
//                }
//                if (op.getSource() == complain) {
//                    Complain obj = new Complain("Complain", accno1, color);
//                    UserTransactions.this.closeFrame();
//                }
                if (op.getSource() == exit) {
                    UserInteraction.this.closeFrame();
                }
            }
        }
    }



