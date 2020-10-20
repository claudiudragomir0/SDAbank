package hibernate.entity;

import javax.persistence.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


@Entity(name = "Customer")
@Table(name = "customer")
public class Customer {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "dateOfBirth")
    private String dateOfBirth;
    @Column(name = "CNP")
    private String cnp;
    @Column(name = "address")
    private String address;
    @Column(name = "phone")
    private String phone;
    @Column (name = "userName")
    private String userName;
    @Column (name = "password")
    private String password;
    @Column(name = "email")
    private String email;
    @ManyToMany(fetch=FetchType.LAZY,
            cascade= {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(
            name="bank_customer",
            joinColumns=@JoinColumn(name="customer_id"),
            inverseJoinColumns=@JoinColumn(name="bank_id")
    )
    private List<Bank> banks;
    @OneToMany(fetch=FetchType.LAZY,
            mappedBy="customer",
            cascade= {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    private List<Account> accounts;

    public Customer() {}

    public Customer(String firstName, String lastName, String dateOfBirth, String cnp, String address, String phone, String userName, String password, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.cnp = cnp;
        this.address = address;
        this.phone = phone;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.banks = banks;
    }
    public List<Bank> getBanks() {
        return banks;
    }
    public void setBanks(List<Bank> banks) {
        this.banks = banks;
    }
    public void addBanks(Bank theBank) {

        if (banks == null) {
            banks = new ArrayList<>();
        }
        banks.add(theBank);
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
    public void addAccounts(Account tempAccount) {

        if (accounts == null) {
            accounts = new ArrayList<>();
        }
        accounts.add(tempAccount);
        tempAccount.setCustomer(this);
    }


    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", CNP=" + cnp +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", banks='" + banks +
                '}';
    }
}
