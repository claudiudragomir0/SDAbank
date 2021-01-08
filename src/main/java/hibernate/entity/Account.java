package hibernate.entity;

import hibernate.util.Iban;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(EnumType.STRING)
    private currency currency;
    private String iban;
    private double balance;
    @Enumerated(EnumType.STRING)
    private accountType accountType;
    @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn
    private Customer customer;
    @OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn
    private List<TransactionHistory> transactionHistory;

    public Account() {
    }

    public Account(int id,currency currency, String iban, double balance, accountType accountType,Customer customer, List<TransactionHistory> transactionHistory) {
        this.id = id;
        this.currency=currency;
        this.iban = iban;
        this.balance=balance;
        this.accountType = accountType;
        this.customer = customer;
        this.transactionHistory = transactionHistory;

    }

    public hibernate.entity.currency getCurrency() {
        return currency;
    }
    public void setCurrency(hibernate.entity.currency currency) {
        this.currency = currency;
    }
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIban() {
        return iban;
    }

    public void setIban() {
        this.iban = Iban.ibanGenerator();
    }

    public hibernate.entity.accountType getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        switch (accountType) {
            case "CREDIT EURO":
                   this.accountType = hibernate.entity.accountType.CREDIT_EURO;
                   this.currency=hibernate.entity.currency.EURO;
                   break;
            case "CREDIT RON":
                   this.accountType = hibernate.entity.accountType.CREDIT_RON;
                this.currency=hibernate.entity.currency.RON;
                   break;
            case "DEBIT EURO":
                   this.accountType = hibernate.entity.accountType.DEBIT_EURO;
                this.currency=hibernate.entity.currency.EURO;
                   break;
            case "DEBIT RON":
                   this.accountType = hibernate.entity.accountType.DEBIT_RON;
                this.currency=hibernate.entity.currency.RON;
                   break;
        }
    }

    public List<TransactionHistory> getTransactionHistoryList() {
        return transactionHistory;
    }

    public void setTransactionHistoryList(List<TransactionHistory> transactionHistoryList) {
        this.transactionHistory = transactionHistoryList;
    }

    public void addTransactions(TransactionHistory tempTransaction) {

        if (transactionHistory == null) {
            transactionHistory = new ArrayList<>();
        }
        transactionHistory.add(tempTransaction);
        tempTransaction.setAccount(this);
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", currency=" + currency +
                ", iban='" + iban + '\'' +
                ", balance=" + balance +
                ", accountType=" + accountType +
                ", customer=" + customer +
                ", transactionHistory=" + transactionHistory +
                '}';
    }
}

