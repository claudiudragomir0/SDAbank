package hibernate;

import hibernate.entity.Account;
import hibernate.entity.Bank;
import hibernate.entity.Customer;
import hibernate.entity.TransactionHistory;
import hibernate.repository.AccountAPI;
import hibernate.repository.BankAPI;
import hibernate.util.Util;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Date;

public class RegisterMenu extends JFrame {

    public static final BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
    public static Bank bank = new Bank();
    public static Transaction transaction = null;
    public static Customer result = null;
    public static Account result1 = null;
    public static Account account = new Account();
    public static BankAPI bankAPI = new BankAPI();
    public static AccountAPI accountAPI = new AccountAPI();

    JPanel header;
    JLabel apptitle,signup, firstName, lastName,age, CNP, email, accountType, phone, address, branch, userName, password;
    JTextField boxFirstName, boxLastName, boxCNP, boxEmail, boxPhone, boxUserName, boxPassword;
    JTextArea boxAddress;
    JComboBox boxAge,boxAge1,boxAge2, boxAccountType, boxBranch;
    JButton back,signupbtn;
    int color;
    RegisterMenu(String title,int v) {
            color=v;
            ImageIcon icon=new ImageIcon("i2.jpg");
            ImageIcon image=new ImageIcon("logo.png");
            JLabel img=new JLabel(image);
            Font signupfont=new Font("SansSerif",Font.BOLD,15);
            Font apptitlefont=new Font("SansSerif",Font.BOLD,30);
            Font label=new Font("SansSerif",Font.PLAIN,15);
            Color bgcolor=new Color(52, 152, 219);
            Color btncolor=new Color(52, 73, 94);
            Color labelcolor=new Color(0,0,0);
            Cursor handpointer=new Cursor(Cursor.HAND_CURSOR);
            header=new JPanel(null);
            header.setBackground(btncolor);
            apptitle=new JLabel("SDA BANK APP");
            apptitle.setForeground(Color.WHITE);
            apptitle.setFont(apptitlefont);
            signup=new JLabel("Register! All fields are mandatory!Try to keep common sense!");
            signup.setForeground(Color.RED);
            signup.setFont(signupfont);
            firstName =new JLabel("First Name:");
            firstName.setForeground(labelcolor);
            firstName.setFont(label);
            lastName =new JLabel("Last Name:");
            lastName.setForeground(labelcolor);
            lastName.setFont(label);
            age=new JLabel("Date Of Birth:                              Day:          Month:          Year:" );
            age.setForeground(labelcolor);
            age.setFont(label);
            CNP =new JLabel("CNP:");
            CNP.setForeground(labelcolor);
            CNP.setFont(label);
            email =new JLabel("Email Adress:");
            email.setForeground(labelcolor);
            email.setFont(label);
            accountType =new JLabel("Select Account Type:");
            accountType.setForeground(labelcolor);
            accountType.setFont(label);
            phone =new JLabel("Phone Number:");
            phone.setForeground(labelcolor);
            phone.setFont(label);
            address=new JLabel("Address:");
            address.setForeground(labelcolor);
            address.setFont(label);
            branch =new JLabel("Select Branch:");
            branch.setForeground(labelcolor);
            branch.setFont(label);
            userName =new JLabel("Set Up User Name:");
            userName.setForeground(labelcolor);
            userName.setFont(label);
            password =new JLabel("Set Up Password:");
            password.setForeground(labelcolor);
            password.setFont(label);
            boxFirstName =new JTextField();
            boxLastName =new JTextField();
            boxCNP =new JTextField();
            boxEmail =new JTextField();
            boxAddress =new JTextArea(8,5);
            boxPhone =new JTextField();
            boxUserName =new JTextField();
            boxPassword =new JTextField();
            back=new JButton("BACK");
            back.setForeground(Color.WHITE);
            back.setFont(label);
            back.setCursor(handpointer);
            back.setBackground(Color.RED);
            signupbtn=new JButton("SIGN UP");
            signupbtn.setForeground(Color.WHITE);
            signupbtn.setFont(label);
            signupbtn.setCursor(handpointer);
            signupbtn.setBackground(btncolor);
            boxAge =new JComboBox();
            for(int i=0;i<32;i++){
            boxAge.addItem(i);
            }
            boxAge1 =new JComboBox();
            for(int i=1;i<13;i++){
            boxAge1.addItem(i);
            }
            boxAge2 =new JComboBox();
            for(int i=2002;i>1930;i--){
            boxAge2.addItem(i);
            }
            boxAccountType =new JComboBox();
            boxAccountType.addItem("Select Account Type");
            boxAccountType.addItem("DEBIT EURO");
            boxAccountType.addItem("DEBIT RON");
            boxAccountType.addItem("CREDIT EURO");
            boxAccountType.addItem("CREDIT RON");
            boxBranch =new JComboBox();
            boxBranch.addItem("Select Branch");
            boxBranch.addItem("SDA BUCURESTI BANK");
            boxBranch.addItem("SDA CLUJ BANK");
            boxBranch.addItem("SDA CONSTANTA BANK");
            boxBranch.addItem("SDA CRAIOVA BANK");
            boxBranch.addItem("SDA SIBIU BANK");
            boxBranch.addItem("SDA IASI BANK");
            boxBranch.addItem("SDA TIMISOARA BANK");
            boxBranch.addItem("SDA INTERNATIONAL BANK");

            this.setLayout(null);
//titlul
            header.setBounds(0,0,500,50);
//mesaj sub titlu
            signup.setBounds(20,51,450,40);
//scris name
            firstName.setBounds(10,100,150,40);
//casuta tname----viitor----boxName
            boxFirstName.setBounds(220,100,240,30);
//scris lastname
            lastName.setBounds(10,140,150,40);
//casuta tlastname-----viitor---boxlastname
            boxLastName.setBounds(220,140,240,30);
//scris age ----date of birth
            age.setBounds(10,180,500,40);
//casuta tage ---- boxdateofbirth
            boxAge.setBounds(250,190,35,20);
            boxAge1.setBounds(335,190,35,20);
            boxAge2.setBounds(410,190,50,20);
//scris ----gender----viitor---branch
            branch.setBounds(10,210,150,40);
//casuta ----tgender----viitor---branch
            boxBranch.setBounds(220,220,240,20);
//scris ----mobilenumber----viitor---phone number
            phone.setBounds(10,250,180,40);
//casuta ----tmobileno----viitor---phone number
            boxPhone.setBounds(220,250,240,30);
            CNP.setBounds(10,290,180,40);
            boxCNP.setBounds(220,290,240,30);
            address.setBounds(10,340,150,40);
            boxAddress.setBounds(220,330,240,70);
            userName.setBounds(10,410,150,40);
            boxUserName.setBounds(220,410,240,30);
            password.setBounds(10,450,150,40);
            boxPassword.setBounds(220,450,240,30);
            accountType.setBounds(10,490,180,40);
            boxAccountType.setBounds(220,500,240,20);
            email.setBounds(10,530,180,40);
            boxEmail.setBounds(220,530,240,30);
            back.setBounds(20,600,200,40);
            signupbtn.setBounds(280,600,200,40);
            apptitle.setBounds(121,10,400,50);
            this.ChangeColor(color);
            img.setBounds(45,0,100,50);
            back.addActionListener(new MyEvents());
            signupbtn.addActionListener(new MyEvents());
            this.add(header);
            header.add(img);
            header.add(apptitle);
            this.add(boxLastName);
            this.add(boxCNP);
            this.add(boxEmail);
            this.add(boxAddress);
            this.add(boxPhone);
            this.add(boxUserName);
            this.add(boxPassword);
            this.add(boxAge);
            this.add(boxAge1);
            this.add(boxAge2);
            this.add(boxAccountType);
            this.add(boxBranch);
            this.add(boxPhone);
            this.add(signup);
            this.add(firstName);
            this.add(lastName);
            this.add(age);
            this.add(branch);
            this.add(userName);
            this.add(CNP);
            this.add(phone);
            this.add(address);
            this.add(accountType);
            this.add(email);
            this.add(password);
            this.add(boxFirstName);
            this.add(boxAge);
            this.add(back);
            this.add(signupbtn);
            this.setIconImage(icon.getImage());
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setTitle(title);
            this.setBounds(520,150,500,680);
            this.setResizable(false);
            this.setVisible(true);

        }
    public void hideFrame()
        {
            this.dispose();
        }
    public void ChangeColor(int v) {
            int rgb[]={52, 73, 94};
            switch(v)
            {
                case 1:
                    rgb[0]=26;
                    rgb[1]=188;
                    rgb[2]=156;
                    break;
                case 2:
                    rgb[0]=22;
                    rgb[1]=160;
                    rgb[2]=133;
                    break;
                case 3:
                    rgb[0]=46;
                    rgb[1]= 204;
                    rgb[2]=133;
                    break;
                case 4:
                    rgb[0]=39;
                    rgb[1]=174;
                    rgb[2]=96;
                    break;
                case 5:
                    rgb[0]=241;
                    rgb[1]=196;
                    rgb[2]=15;
                    break;
                case 6:
                    rgb[0]=243;
                    rgb[1]=156;
                    rgb[2]=181;
                    break;
                case 7:
                    rgb[0]=211;
                    rgb[1]=84;
                    rgb[2]=0;
                    break;
                case 8:
                    rgb[0]=155;
                    rgb[1]=89;
                    rgb[2]=182;
                    break;
                case 9:
                    rgb[0]=142;
                    rgb[1]=68;
                    rgb[2]=173;
                    break;
                case 10:
                    rgb[0]=52;
                    rgb[1]=73;
                    rgb[2]=94;
                    break;
                case 11:
                    rgb[0]=44;
                    rgb[1]=62;
                    rgb[2]=80;
                    break;
                case 12:
                    rgb[0]=189;
                    rgb[1]=195;
                    rgb[2]=199;
                    break;
                case 13:

                    rgb[0]=149;
                    rgb[1]=165;
                    rgb[2]=166;
                    break;
                case 14:

                    rgb[0]=127;
                    rgb[1]=140;
                    rgb[2]=141;
                    color=0;
                    break;
            }
            Color btncolor=new Color(rgb[0],rgb[1],rgb[2]);
            signupbtn.setBackground(btncolor);
            header.setBackground(btncolor);
        }
    public static void main(String args[]) {
            RegisterMenu obj=new RegisterMenu("Register Account",0);
        }
    class MyEvents implements ActionListener {
        private hibernate.entity.bankName bankName;

        public void actionPerformed(ActionEvent op){
                if(op.getSource()==signupbtn) {
                    try {
                        String textFirstName = boxFirstName.getText();
                        String textLastName = boxLastName.getText();
                        String textCNP = boxCNP.getText();
                        String textPhone = boxPhone.getText();
                        String textUserName = boxUserName.getText();
                        String textPassword = boxPassword.getText();
                        String textAddress = boxAddress.getText();
                        String textBranch = "" + (String) boxBranch.getSelectedItem();
                        String textAccounType = "" + (String) boxAccountType.getSelectedItem();
                        String textAge =(Integer) boxAge.getSelectedItem()+"/"+(Integer) boxAge1.getSelectedItem()+"/"+(Integer) boxAge2.getSelectedItem();
                        String textEmail = boxEmail.getText();
                        int age = (int) boxAge.getSelectedItem();
                        float bal = 0;
                        String initial = boxEmail.getText();
                        int flag = 0;

                        if(textPhone.length() != 10||textPhone.equals("             Phone number is of length 10!")) {
                            flag=1;
                            boxPhone.setFont(new Font("SansSerif",Font.BOLD,15));
                            boxPhone.setForeground(Color.RED);
                            boxPhone.setText("             Phone number is of length 10!");
                        }
                        if(textCNP.length() != 13||textCNP.equals("CNP must have length of 13")) {
                            flag=1;
                            boxCNP.setFont(new Font("SansSerif",Font.BOLD,15));
                            boxCNP.setForeground(Color.RED);
                            boxCNP.setText("CNP must have length of 13!");
                        }
                        if(textAccounType.equals("Select Account Type")) {
                            flag=1;
                            boxAccountType.setForeground(Color.RED);
                        }
                        if(textBranch.equals("Select Branch")) {
                            flag=1;
                            boxBranch.setForeground(Color.RED);
                        }
//                        if(age==0) {
//                            flag=1;
//                            boxAge.setForeground(Color.RED);
//                        }
                        if(textEmail.equals("")||textEmail.equals("             Empty Field!")){
                            flag=1;
                            boxEmail.setFont(new Font("SansSerif",Font.BOLD,15));
                            boxEmail.setForeground(Color.RED);
                            boxEmail.setText("             Empty Field!");
                        }
                        if(textPassword.equals("")||textPassword.equals("             Empty Field!")){
                            flag=1;
                            boxPassword.setFont(new Font("SansSerif",Font.BOLD,15));
                            boxPassword.setForeground(Color.RED);
                            boxPassword.setText("             Empty Field!");
                        }
                        if(textAddress.equals("")||textAddress.equals("             Empty Field!")){
                            flag=1;
                            boxAddress.setFont(new Font("SansSerif",Font.BOLD,15));
                            boxAddress.setForeground(Color.RED);
                            boxAddress.setText("             Empty Field!");
                        }
                        if(textUserName.equals("")||textUserName.equals("             Empty Field!")){
                            flag=1;
                            boxUserName.setFont(new Font("SansSerif",Font.BOLD,15));
                            boxUserName.setForeground(Color.RED);
                            boxUserName.setText("             Empty Field!");
                        }
                        if(textFirstName.equals("")||textFirstName.equals("             Empty Field!")){
                            flag=1;
                            boxFirstName.setFont(new Font("SansSerif",Font.BOLD,15));
                            boxFirstName.setForeground(Color.RED);
                            boxFirstName.setText("             Empty Field!");
                        }
                        if(textLastName.equals("")||textLastName.equals("             Empty Field!")){
                            flag=1;
                            boxLastName.setFont(new Font("SansSerif",Font.BOLD,15));
                            boxLastName.setForeground(Color.RED);
                            boxLastName.setText("             Empty Field!");
                        }

                        if (flag == 0) {
                            try (Session session = Util.getSessionFactory().openSession()) {
                                session.beginTransaction();
                                int bankId;
                                String bankName;
                                Bank newBank = new Bank();

                                switch (bankName = textBranch.toUpperCase()) {
                                    case "SDA BUCURESTI BANK":
                                        this.bankName = hibernate.entity.bankName.SDA_BUCURESTI;
                                        bankId = 1;
                                        break;
                                    case "SDA CLUJ BANK":
                                        this.bankName = hibernate.entity.bankName.SDA_CLUJ;
                                        bankId = 2;
                                        break;
                                    case "SDA CONSTANTA BANK":
                                        this.bankName = hibernate.entity.bankName.SDA_CONSTANTA;
                                        bankId = 3;
                                        break;
                                    case "SDA CRAIOVA BANK":
                                        this.bankName = hibernate.entity.bankName.SDA_CRAIOVA;
                                        bankId = 4;
                                        break;
                                    case "SDA SIBIU BANK":
                                        this.bankName = hibernate.entity.bankName.SDA_SIBIU;
                                        bankId = 5;
                                        break;
                                    case "SDA IASI BANK":
                                        this.bankName = hibernate.entity.bankName.SDA_IASI;
                                        bankId = 6;
                                        break;
                                    case "SDA TIMISOARA BANK":
                                        this.bankName = hibernate.entity.bankName.SDA_TIMISOARA;
                                        bankId = 7;
                                        break;
                                    case "SDA INTERNATIONAL BANK":
                                        this.bankName = hibernate.entity.bankName.SDA_INTERNATIONAL;
                                        bankId = 8;
                                        break;
                                    default:
                                        throw new IllegalStateException("Unexpected value: " + bankName);
                                }
                                Bank tempBank = session.get(Bank.class, bankId);
                                Customer tempCustomer = new Customer();
                                tempCustomer.setFirstName(textFirstName);
                                tempCustomer.setLastName(textLastName);
                                tempCustomer.setDateOfBirth(textAge);
                                tempCustomer.setCnp(textCNP);
                                tempCustomer.setAddress(textAddress);
                                tempCustomer.setPhone(textPhone);
                                tempCustomer.setUserName(textUserName);
                                tempCustomer.setPassword(textPassword);
                                tempCustomer.setEmail(textEmail);
                                session.save(tempBank);
                                tempBank.addCustomers(tempCustomer);
                                session.save(tempCustomer);
                                int customerId = tempCustomer.getId();
                                result = session.find(Customer.class, customerId);
                                Account tempAccount = new Account();

                                tempAccount.setAccountType(textAccounType);
                                tempAccount.setIban();
                                session.save(tempCustomer);
                                tempCustomer.addAccounts(tempAccount);
                                session.save(tempAccount);

                                int accountId = tempAccount.getId();
                                result1 = session.find(Account.class, accountId);
                                TransactionHistory tempTransactionHistory = new TransactionHistory();
                                tempAccount.addTransactions(tempTransactionHistory);
                                session.save(tempAccount);

                                tempTransactionHistory.setAccount(tempAccount);
                                tempTransactionHistory.setCurrency(""+tempAccount.getCurrency());
                                tempTransactionHistory.setChanged_at(new Date());
                                session.save(tempTransactionHistory);


//                                session.getTransaction().commit();
                            } catch (HibernateException e) {
                                if (transaction != null) {
                                    transaction.rollback();
                                }
                                System.out.println(e.getMessage());
                            }//hibernate querry  register end
                            RegisterMenu.this.hideFrame();
                            //aici se inchide flag si este setat la 0
                            StartUp obj=new StartUp("SDA APP",color);
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e, "Error message", JOptionPane.ERROR_MESSAGE);
                    }
                }
                    if(op.getSource()==back)
                {
                    System.out.println(color);
                    StartUp obj=new StartUp("SDA APP",color);
                    RegisterMenu.this.hideFrame();
                }
            }
        }
}



