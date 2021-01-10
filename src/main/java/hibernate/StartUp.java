package hibernate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartUp extends JFrame {
    JButton changethemecolor, createacc, login, exit;
    JLabel Bankname, SelectLine, logoimg;
    JPanel header;
    int color;
    StartUp(String title, int v) {
        color = v;
        Color btn2color = new Color(155, 89, 182);
        Color bgcolor = new Color(52, 152, 219);
        Font btnfont = new Font("SansSerif", Font.PLAIN, 15);
        Font linefont = new Font("SansSerif", Font.BOLD, 20);
        Font banklinefont = new Font("SansSerif", Font.BOLD, 25);
        Cursor handpointer = new Cursor(Cursor.HAND_CURSOR);
        ImageIcon icon = new ImageIcon("i2.jpg");
        ImageIcon backgroundImage = new ImageIcon("bg.jpg");
        ImageIcon logo = new ImageIcon("logo.png");
        logoimg = new JLabel(logo);
        header = new JPanel(null);
        SelectLine = new JLabel("Select from the following Operations");
        Bankname = new JLabel("SDA BANK APP");
        createacc = new JButton("CREATE ACCOUNT");
        login = new JButton("LOGIN");
        changethemecolor = new JButton("CHANGE THEME");
        exit = new JButton("EXIT");
        this.setLayout(null);
        Bankname.setForeground(Color.WHITE);
        Bankname.setFont(banklinefont);
        SelectLine.setForeground(Color.BLACK);
        SelectLine.setFont(linefont);
        createacc.setForeground(Color.WHITE);
        createacc.setFont(btnfont);
        createacc.setCursor(handpointer);
        login.setForeground(Color.WHITE);
        login.setFont(btnfont);
        login.setCursor(handpointer);
        changethemecolor.setForeground(Color.WHITE);
        changethemecolor.setFont(btnfont);
        changethemecolor.setCursor(handpointer);
        exit.setBackground(Color.RED);
        exit.setForeground(Color.WHITE);
        exit.setFont(btnfont);
        exit.setCursor(handpointer);
        logoimg.setBounds(45, 0, 100, 50);
        header.setBounds(0, 0, 500, 50);
        Bankname.setBounds(121, 10, 400, 50);
        SelectLine.setBounds(70, 51, 500, 30);
        createacc.setBounds(140, 101, 200, 30);
        login.setBounds(140, 151, 200, 30);
        changethemecolor.setBounds(140, 211, 200, 30);
        exit.setBounds(140, 261, 200, 30);
        this.add(header);
        ChangeColor(color);
        header.add(logoimg);
        header.add(Bankname);
        this.add(SelectLine);
        this.add(createacc);
        this.add(login);
        this.add(changethemecolor);
        this.add(exit);
        createacc.addActionListener(new EventHandling());
        login.addActionListener(new EventHandling());
        changethemecolor.addActionListener(new EventHandling());
        exit.addActionListener(new EventHandling());
        this.setIconImage(icon.getImage());
        this.setResizable(false);
        this.setTitle(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(520, 225, 500, 350);
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
        login.setBackground(btncolor);
        createacc.setBackground(btncolor);
        changethemecolor.setBackground(btncolor);
        header.setBackground(btncolor);
    }

    public static void main(String args[]) {
        StartUp obj = new StartUp("SDA BANK ", 0);
    }

    class EventHandling implements ActionListener {
        public void actionPerformed(ActionEvent op) {
            if (op.getSource() == login) {
                Login obj = new Login("LOGIN", color);
                StartUp.this.hideFrame();
            }
            if (op.getSource() == changethemecolor) {
                color++;
                StartUp.this.ChangeColor(color);
            }
            if (op.getSource() == createacc) {
                //register
                RegisterMenu obj = new RegisterMenu("Create Account", color);
                StartUp.this.hideFrame();
            }

            if (op.getSource() == exit) {
                StartUp.this.hideFrame();
            }
        }
    }
}